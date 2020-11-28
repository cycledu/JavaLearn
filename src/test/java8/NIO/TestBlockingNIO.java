package java8.NIO;

/**
 * @Author : jingtao
 * @Data : 2020/10/31/21:24
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */

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
 * 一、使用NIO完成网络通信的三个核心
 * 1、通道：负责连接
 * <p>
 * 2、缓冲器：负责数据存取
 * |--SelectableChannel
 *  |--SocketChannel
 *  |--ServerSocketChannel
 *  |--DatagramChannel
 * <p>
 *  |--Pipe.SinkChannel
 *  |--Pipe.SourceChannel
 * 3、选择器：是SelectableChannel的多路复用器，用于监控SelectableChannel的IO状态
 */
public class TestBlockingNIO {

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
        outChannel.close();
        socketChannel.close();
        accept.close();
    }
}
