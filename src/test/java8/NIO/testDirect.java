package java8.NIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;

/**
 * @Author : jingtao
 * @Data : 2020/11/10/10:40
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class testDirect {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("");
        FileChannel channel = fileOutputStream.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY,0,1024);
//        channel.lock()
    }
}
