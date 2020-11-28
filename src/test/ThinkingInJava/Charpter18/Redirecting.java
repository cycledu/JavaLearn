package ThinkingInJava.Charpter18;

import java.io.*;

/**
 * @Author : jingtao
 * @Data : 2020/07/10/21:46
 * @Description :P550
 * @Page or WebSite：
 * @Expected result ：
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("G:\\Springboot\\ThinkingInJava\\src\\Charpter18\\Test07.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("G:\\Springboot\\ThinkingInJava\\src" +
                "\\Charpter18\\toolTest.out")));
        System.setIn(in);
        System.setOut(out);
        PrintStream err = new PrintStream(new BufferedOutputStream(new FileOutputStream("G:\\Springboot" +
                "\\ThinkingInJava\\src" +
                "\\Charpter18\\err.txt")));
        System.setErr(err);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            System.err.println(s);
        }
        out.flush();
        err.close();
//        System.setOut(out);
//        System.setErr(err);
    }
}
