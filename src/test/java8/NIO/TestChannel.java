package java8.NIO;

/**
 * @Author : jingtao
 * @Data : 2020/10/31/19:30
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * ͨ��������Դ�ڵ���Ŀ��ڵ�����ӣ������洢���ݣ������Ҫ��ϻ��������д���
 * <p>
 * ��Ҫʵ����
 * FileChannel
 * SockerChannel
 * ServerSockerChannel
 * DatagramChannel
 * <p>
 * ��ȡͨ���ķ���
 * 1��ʹ��֧��ͨ�������getChannel()����
 * ���������л�ȡͨ���ķ���
 * 2��JDK1.7��NIO2��Ը���ͨ���ṩ�˾�̬����FileChannel.open()
 * 3��JDK1.7��NIO2��Files�������newByteChannel()
 * <p>
 * ͨ��֮������ݴ���
 *  ֱ��ʹ��transferTo��transferFrom����
 *
 * ��ɢ��Scatter����ۼ���Gather������˳�����η�ɢ��ۼ���read��write���β�Ϊ�ֽ�����ķ�����ByteBuffer[] xxx��
 * ��ɢ��ȡ��Scattering Reads������ͨ���е����ݷ�ɢ��ȡ�������������
 * �ۼ�д�루Gathering Writes����������������е����ݻ㼯��ͨ����
 *
 * �ַ�����Charset
 * ���룺�ַ���->�ֽ�����
 * ���룺�ֽ�����->�ַ���
 * java.nio.charset.Charset#availableCharsets()����ȡ�����ַ���
 *java.nio.charset.Charset#forName(java.lang.String)���õ�һ���ַ�
 * java.nio.charset.Charset#newDecoder()����ȡָ���ַ��Ľ�����
 * java.nio.charset.Charset#newEncoder()����ȡָ���ַ��ı�����
 * java.nio.charset.CharsetDecoder���������������н���ķ���
 * java.nio.charset.CharsetEncoder���������������б���ķ���
 */
public class TestChannel {


    //����ͨ������ļ����ƣ���ֱ�ӻ�������
    @Test
    public void test() throws IOException {
        //��ȡ��
        FileInputStream inputStream = new FileInputStream("C:\\Users\\jingtao\\Pictures\\btn_selctor1.jpg");
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\jingtao\\Desktop\\2.jpg");
        //��ȡͨ��
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();

        //ָ��������
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while ((inChannel.read(buffer)) != -1) {//��ͨ�������ݶ���������
            buffer.flip();
            outChannel.write(buffer);//�����ݴӻ������ж���ͨ��
            buffer.clear();
        }
        outChannel.close();
        inChannel.close();
        inputStream.close();
        outputStream.close();
    }

    //ʹ��ֱ�ӻ���������ļ��ĸ��ƣ��ڴ�ӳ���ļ���
    @Test
    public void tes2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("C:\\Users\\jingtao\\Pictures\\btn_selctor1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\jingtao\\Desktop\\2.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        MappedByteBuffer inMapBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] bytes = new byte[inMapBuffer.limit()];
        inMapBuffer.get(bytes);
        outMapBuffer.put(bytes);

        inChannel.close();
        outChannel.close();
    }

    @Test
    public void tes3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("C:\\Users\\jingtao\\Pictures\\btn_selctor1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\jingtao\\Desktop\\2.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inChannel.close();
        outChannel.close();
    }
}
