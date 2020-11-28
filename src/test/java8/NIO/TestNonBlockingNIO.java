package java8.NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * @Author : jingtao
 * @Data : 2020/10/31/21:53
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class TestNonBlockingNIO {
    //客户端
    @Test
    public void client() throws IOException {
        //1、获取通道
        SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));
        //切换成非阻塞模式
        schannel.configureBlocking(false);
        //2、分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(LocalDateTime.now().toString().getBytes());
        buffer.flip();
        //4、发送数据
        schannel.write(buffer);
        //接收服务端的反馈
        schannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //1、获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        //2、绑定端口号
        ssChannel.bind(new InetSocketAddress(9988));
        //3、获取客户端连接的通道
        SocketChannel cchannel = ssChannel.accept();
        //4、获取选择器
        Selector selector = Selector.open();
        //5、将通道注册到选择器,指定监听事件（接收事件）
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6、轮询式获取选择器上已经准备就绪的事件
        while (selector.select() > 0) {
            //7、获取当前选择器中所有注册的选择键（已就绪的监听事件）
            Iterator<SelectionKey> selectionKey = selector.selectedKeys().iterator();
            while (selectionKey.hasNext()) {
                //8、获取准备就绪的事件
                SelectionKey sk = selectionKey.next();
                //9、判断具体何事件已经准备就绪
                if (sk.isAcceptable()) {
                    //10、若接收就绪，获取客户端连接
                    SocketChannel sChannel = ssChannel.accept();
                    //11、切换到非阻塞模式
                    sChannel.configureBlocking(false);
                    //12、将channel注册到selectors上
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    //13、获取当前选择器上读就绪状态的通道
                    SocketChannel channel = (SocketChannel) sk.channel();
                    //14、读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = channel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }
                //取消选择键
                selectionKey.remove();
            }

        }
        ssChannel.close();
        cchannel.close();
    }
}
