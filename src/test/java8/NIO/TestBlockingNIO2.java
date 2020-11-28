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
 * @PageOrWebSite��
 * @Expected result ��
 */
public class TestBlockingNIO2 {
    //�ͻ���
    @Test
    public void client() throws IOException {
        //1����ȡͨ��
        SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));
        //2������ָ����С�Ļ�����
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //3����ȡ�����ļ��������͵�������
        FileChannel inChannel = FileChannel.open(Paths.get("C:\\Users\\jingtao\\Pictures\\btn_selctor1.jpg"),
                StandardOpenOption.READ);
        //4����������
        while ((inChannel.read(buffer) != -1)) {
            buffer.flip();
            schannel.write(buffer);
            buffer.clear();
        }
        schannel.shutdownOutput();
        //���շ���˵ķ���
        int len = 0;
        while ((len = schannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }
        inChannel.close();
        schannel.close();
    }

    //�����
    @Test
    public void server() throws IOException {
        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\jingtao\\Desktop\\2.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
        //1����ȡͨ��
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        //2���󶨶˿ں�
        socketChannel.bind(new InetSocketAddress(9988));
        //3����ȡ�ͻ������ӵ�ͨ��
        SocketChannel accept = socketChannel.accept();
        //4����ͨ���л�ȡ����
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while ((accept.read(buffer)) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        buffer.put("���ճɹ�".getBytes());
        buffer.flip();
        accept.write(buffer);

        outChannel.close();
        socketChannel.close();
        accept.close();
    }
}
