package ThinkingInJava.Charpter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author : jingtao
 * @Data : 2020/04/20/21:38
 * @Description :
 * @Page or WebSite：540
 * @Expected result ：
 */
public class BufferedInputFile {
    public static String read(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s=in.readLine())!=null)
            sb.append(s+"\n");
        in.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.println(read("G:\\Springboot\\ThinkingInJava\\src\\Charpter18\\BufferedInputFile.java"));
    }
}
