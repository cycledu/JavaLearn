package ThinkingInJava.Charpter18;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : jingtao
 * @Data : 2020/07/10/21:36
 * @Description :
 * @Page or WebSite：P549
 * @Expected result ：
 */
public class Test21 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s.toUpperCase());
        }
    }

    @Test
    public void test() throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s.toUpperCase());
        }
    }
}
