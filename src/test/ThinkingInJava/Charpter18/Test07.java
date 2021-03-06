package ThinkingInJava.Charpter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/07/08/22:56
 * @Description :
 * @Page or WebSite：p540
 * @Expected result ：
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("E:\\2020-01-23.txt"));
        List<String> linkedList = new LinkedList<>();
        String s;
        while ((s = in.readLine()) != null) {
            linkedList.add(s);
        }
        Collections.reverse(linkedList);
        linkedList.stream().forEach(System.out::println);
        System.out.println("==============================");
        linkedList.stream().map(v->v.toUpperCase()).forEach(System.out::println);
        System.out.println("===============================");
        linkedList.stream().filter(v->v.contains("Window.")).forEach(System.out::println);
    }
}
