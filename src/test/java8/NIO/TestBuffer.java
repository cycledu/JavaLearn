package java8.NIO;

/**
 * @Author : jingtao
 * @Data : 2020/10/31/18:47
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Random;

/**
 * 缓冲区：在NIO中负责数据的存取，就是数组，用于存储不同数据类型的数据
 * 根据数据类型的不同，提供了相应的缓冲区（除了boolean）
 * 缓冲的管理方式几乎一致，通过allocate()获取缓冲区
 * <p>
 * 存取数据的核心方法
 * put()：存入数据到缓冲区
 * get()：从缓冲区取出数据
 * <p>
 * 缓冲区核心属性
 * capacity:表示缓冲区中存储数据的最大荣强
 * limit：表示缓冲区中可以操作数据的大小（limit后面的数据不能读写）
 * position：表示缓冲区中正在操作数据的位置
 * mark：标记，可以通过记录当前position的位置，可以通过reset()恢复到上一次mark的位置
 * <p>
 * position<=limit<=capacity
 * <p>
 * 直接缓冲区和非直接缓冲区
 * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中
 * 直接缓冲区：通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中，可以提高效率
 */
public class TestBuffer {
    @Test
    public void test() {
        String s = "abcde";
        //1、分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        soutDetail(buffer);
        buffer.put(s.getBytes());
        /**
         * Flips this buffer.  The limit is set to the current position and then
         * the position is set to zero.  If the mark is defined then it is
         * discarded.
         */
        buffer.flip();
        System.out.println("--------------------写数据后--------------------");
        soutDetail(buffer);
        System.out.println(buffer.get(0));
        byte[] bytes = new byte[5];
        ByteBuffer byteBuffer = buffer.get(bytes, 0, 5);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println("--------------------读数据后--------------------");
        soutDetail(buffer);
        System.out.println("--------------------rewind后--------------------");
        buffer.rewind();
        soutDetail(buffer);
        System.out.println("clear后：清空缓冲区，但是缓冲区的数据依然存在，但是处于'被遗忘'状态");
        buffer.clear();
        System.out.println("重新设置position，并记录，然后改变position，使用reset()");
        buffer.position(2);//设置position的位置
        soutDetail(buffer);
        buffer.mark();
        System.out.println("-----------------------改变position");
        buffer.position(4);
        soutDetail(buffer);
        System.out.println("-----------------------reset()后");
        buffer.reset();
        soutDetail(buffer);

    }

    @Test
    public void testDirect() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        System.out.println(byteBuffer.isDirect());
    }

    public static void soutDetail(ByteBuffer buffer) {
        System.out.println("此时的容量" + buffer.capacity());
        System.out.println("此时的限制" + buffer.limit());
        System.out.println("此时的位置" + buffer.position());
    }
}
