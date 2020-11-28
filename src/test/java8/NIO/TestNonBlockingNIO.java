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
 * @PageOrWebSite��
 * @Expected result ��
 */
public class TestNonBlockingNIO {
    //�ͻ���
    @Test
    public void client() throws IOException {
        //1����ȡͨ��
        SocketChannel schannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));
        //�л��ɷ�����ģʽ
        schannel.configureBlocking(false);
        //2������ָ����С�Ļ�����
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(LocalDateTime.now().toString().getBytes());
        buffer.flip();
        //4����������
        schannel.write(buffer);
        //���շ���˵ķ���
        schannel.close();
    }

    //�����
    @Test
    public void server() throws IOException {
        //1����ȡͨ��
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        //2���󶨶˿ں�
        ssChannel.bind(new InetSocketAddress(9988));
        //3����ȡ�ͻ������ӵ�ͨ��
        SocketChannel cchannel = ssChannel.accept();
        //4����ȡѡ����
        Selector selector = Selector.open();
        //5����ͨ��ע�ᵽѡ����,ָ�������¼��������¼���
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6����ѯʽ��ȡѡ�������Ѿ�׼���������¼�
        while (selector.select() > 0) {
            //7����ȡ��ǰѡ����������ע���ѡ������Ѿ����ļ����¼���
            Iterator<SelectionKey> selectionKey = selector.selectedKeys().iterator();
            while (selectionKey.hasNext()) {
                //8����ȡ׼���������¼�
                SelectionKey sk = selectionKey.next();
                //9���жϾ�����¼��Ѿ�׼������
                if (sk.isAcceptable()) {
                    //10�������վ�������ȡ�ͻ�������
                    SocketChannel sChannel = ssChannel.accept();
                    //11���л���������ģʽ
                    sChannel.configureBlocking(false);
                    //12����channelע�ᵽselectors��
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    //13����ȡ��ǰѡ�����϶�����״̬��ͨ��
                    SocketChannel channel = (SocketChannel) sk.channel();
                    //14����ȡ����
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = channel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }
                //ȡ��ѡ���
                selectionKey.remove();
            }

        }
        ssChannel.close();
        cchannel.close();
    }
}
