package ThinkingInJava.Charpter18;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Author : jingtao
 * @Data : 2020/04/20/21:44
 * @Description :
 * @Page or WebSite：541
 * @Expected result ：
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("G:\\Springboot\\ThinkingInJava\\src\\Charpter18\\MemoryInput.java"));
        int c;
        while ((c=in.read())!=-1)
            System.out.print((char)c);
    }
}
