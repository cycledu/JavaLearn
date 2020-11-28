package ThinkingInJava.Charpter18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @Author : jingtao
 * @Data : 2020/04/20/21:47
 * @Description :
 * @Page or WebSite:541
 * @Expected result ：
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.
                    read("G:\\Springboot\\ThinkingInJava\\src\\Charpter18\\FormattedMemoryInput.java").getBytes()));
            while (true)
                System.out.print((char)in.readByte());
        }catch (EOFException e){
            System.err.println("End of stream");
        }
    }
}
