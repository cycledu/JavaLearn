package java8.NIO;

/**
 * @Author : jingtao
 * @Data : 2020/10/31/18:47
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Random;

/**
 * ����������NIO�и������ݵĴ�ȡ���������飬���ڴ洢��ͬ�������͵�����
 * �����������͵Ĳ�ͬ���ṩ����Ӧ�Ļ�����������boolean��
 * ����Ĺ���ʽ����һ�£�ͨ��allocate()��ȡ������
 * <p>
 * ��ȡ���ݵĺ��ķ���
 * put()���������ݵ�������
 * get()���ӻ�����ȡ������
 * <p>
 * ��������������
 * capacity:��ʾ�������д洢���ݵ������ǿ
 * limit����ʾ�������п��Բ������ݵĴ�С��limit��������ݲ��ܶ�д��
 * position����ʾ�����������ڲ������ݵ�λ��
 * mark����ǣ�����ͨ����¼��ǰposition��λ�ã�����ͨ��reset()�ָ�����һ��mark��λ��
 * <p>
 * position<=limit<=capacity
 * <p>
 * ֱ�ӻ������ͷ�ֱ�ӻ�����
 * ��ֱ�ӻ�������ͨ��allocate()�������仺��������������������JVM���ڴ���
 * ֱ�ӻ�������ͨ��allocateDirect()��������ֱ�ӻ��������������������������ڴ��У��������Ч��
 */
public class TestBuffer {
    @Test
    public void test() {
        String s = "abcde";
        //1������һ��ָ����С�Ļ�����
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        soutDetail(buffer);
        buffer.put(s.getBytes());
        /**
         * Flips this buffer.  The limit is set to the current position and then
         * the position is set to zero.  If the mark is defined then it is
         * discarded.
         */
        buffer.flip();
        System.out.println("--------------------д���ݺ�--------------------");
        soutDetail(buffer);
        System.out.println(buffer.get(0));
        byte[] bytes = new byte[5];
        ByteBuffer byteBuffer = buffer.get(bytes, 0, 5);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("--------------------�����ݺ�--------------------");
        soutDetail(buffer);
        System.out.println("--------------------rewind��--------------------");
        buffer.rewind();
        soutDetail(buffer);
        System.out.println("clear����ջ����������ǻ�������������Ȼ���ڣ����Ǵ���'������'״̬");
        buffer.clear();
        System.out.println("��������position������¼��Ȼ��ı�position��ʹ��reset()");
        buffer.position(2);//����position��λ��
        soutDetail(buffer);
        buffer.mark();
        System.out.println("-----------------------�ı�position");
        buffer.position(4);
        soutDetail(buffer);
        System.out.println("-----------------------reset()��");
        buffer.reset();
        soutDetail(buffer);

    }

    @Test
    public void testDirect() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());
    }

    public static void soutDetail(ByteBuffer buffer) {
        System.out.println("��ʱ������" + buffer.capacity());
        System.out.println("��ʱ������" + buffer.limit());
        System.out.println("��ʱ��λ��" + buffer.position());
    }
}
