package ThinkingInJava.Charpter17.practise11;

import java.util.PriorityQueue;

/**
 * @Author : jingtao
 * @Data : 2020/05/17/20:02
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        PriorityQueue<Test> tests = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            tests.add(new Test());
        }

        tests.forEach(test -> System.out.print(test+ " "));
    }
}
