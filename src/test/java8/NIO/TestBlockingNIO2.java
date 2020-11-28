package java8.NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author : jingtao
 * @Data : 2020/10/31/21:42
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class TestBlockingNIO2 {
    //客户端
    @Test
    public void client() throws IOException {
        //1、获取通道
        SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));
        //2、分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //3、读取本地文件，并发送到服务器
        FileChannel inChannel = FileChannel.open(Paths.get("C:\\Users\\jingtao\\Pictures\\btn_selctor1.jpg"),
                StandardOpenOption.READ);
        //4、发送数据
        while ((inChannel.read(buffer) != -1)) {
            buffer.flip();
            schannel.write(buffer);
            buffer.clear();
        }
        schannel.shutdownOutput();
        //接收服务端的反馈
        int len = 0;
        while ((len = schannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }
        inChannel.close();
        schannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\jingtao\\Desktop\\2.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
        //1、获取通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        //2、绑定端口号
        socketChannel.bind(new InetSocketAddress(9988));
        //3、获取客户端连接的通道
        SocketChannel accept = socketChannel.accept();
        //4、从通道中获取数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while ((accept.read(buffer)) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        buffer.put("接收成功".getBytes());
        buffer.flip();
        accept.write(buffer);

        outChannel.close();
        socketChannel.close();
        accept.close();
    }
}
