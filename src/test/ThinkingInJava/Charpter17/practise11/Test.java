package ThinkingInJava.Charpter17.practise11;

import java.util.Random;

/**
 * @Author : jingtao
 * @Data : 2020/05/17/19:48
 * @Description :
 * @Page or WebSite：P482/练习11
 * @Expected result ：
 */
public class Test implements Comparable<Test> {
    private Integer integer;

    public Test() {
        this.integer = new Random().nextInt(100);
    }
    @Override
    public int compareTo(Test o) {
        if (this.integer > o.integer) {
            return 1;
        } else if (this.integer < o.integer) {
            return -1;
        } else
            return 0;
    }
    @Override
    public String toString() {
        return "{integer=" + integer + '}';
    }
}
