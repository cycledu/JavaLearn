package ThinkingInJava.Charpter18;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * @Author : jingtao
 * @Data : 2020/07/11/15:46
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class JGrep {
    public static void main(String[] args) throws Exception {
        File file = new File("G:\\Learn\\JavaSourceLearn\\src\\toolTest\\ThinkingInJava\\Charpter18\\err.txt");
        long len = file.length();
        byte[] ds = new byte[(int) len];
        try {
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r").getChannel().map(FileChannel.MapMode.READ_ONLY, 0, len);
            for (int offset = 0; offset < len; offset++) {
                byte b = mappedByteBuffer.get();
                ds[offset] = b;
            }
            Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");
            while (scan.hasNext()) {
                System.out.print(scan.next() + " ");
            }
        } catch (IOException e) {
        }
    }
}
