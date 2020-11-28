package java8.NIO;

/**
 * @Author : jingtao
 * @Data : 2020/10/31/19:30
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
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
 * 通道：用于源节点与目标节点的连接，本身不存储数据，因此需要配合缓冲区进行传输
 * <p>
 * 主要实现类
 * FileChannel
 * SockerChannel
 * ServerSockerChannel
 * DatagramChannel
 * <p>
 * 获取通道的方法
 * 1、使用支持通道的类的getChannel()方法
 * 各种流中有获取通道的方法
 * 2、JDK1.7中NIO2针对各个通道提供了静态方法FileChannel.open()
 * 3、JDK1.7中NIO2的Files工具类的newByteChannel()
 * <p>
 * 通道之间的数据传输
 *  直接使用transferTo、transferFrom方法
 *
 * 分散（Scatter）与聚集（Gather）：按顺序依次分散或聚集（read和write中形参为字节数组的方法：ByteBuffer[] xxx）
 * 分散读取（Scattering Reads）：将通道中的数据分散读取到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据汇集到通道中
 *
 * 字符集：Charset
 * 编码：字符串->字节数组
 * 解码：字节数组->字符串
 * java.nio.charset.Charset#availableCharsets()：获取所有字符集
 *java.nio.charset.Charset#forName(java.lang.String)：得到一个字符
 * java.nio.charset.Charset#newDecoder()：获取指定字符的解码器
 * java.nio.charset.Charset#newEncoder()：获取指定字符的编码器
 * java.nio.charset.CharsetDecoder：解码器：其中有解码的方法
 * java.nio.charset.CharsetEncoder：编码器：其中有编码的方法
 */
public class TestChannel {


    //利用通道完成文件复制（非直接缓冲区）
    @Test
    public void test() throws IOException {
        //获取流
        FileInputStream inputStream = new FileInputStream("C:\\Users\\jingtao\\Pictures\\btn_selctor1.jpg");
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\jingtao\\Desktop\\2.jpg");
        //获取通道
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();

        //指定缓冲器
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while ((inChannel.read(buffer)) != -1) {//将通道中数据读到缓冲区
            buffer.flip();
            outChannel.write(buffer);//将数据从缓冲区中读到通道
            buffer.clear();
        }
        outChannel.close();
        inChannel.close();
        inputStream.close();
        outputStream.close();
    }

    //使用直接缓冲区完成文件的复制（内存映射文件）
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
