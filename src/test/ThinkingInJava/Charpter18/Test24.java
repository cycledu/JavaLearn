package ThinkingInJava.Charpter18;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * @Author : jingtao
 * @Data : 2020/07/10/23:21
 * @Description : p558
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test24 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        doubleBuffer.put(new double[]{1d,2d,3d,4d,6d});
        doubleBuffer.flip();
        while (doubleBuffer.hasRemaining()){
            System.out.println(doubleBuffer.get());
        }
    }
}
