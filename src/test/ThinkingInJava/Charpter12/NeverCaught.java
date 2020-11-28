package ThinkingInJava.Charpter12;

/**
 * @Author : jingtao
 * @Data : 2020/04/01/23:38
 * @Description :
 * @Page or WebSite：264
 * @Expected result ：
 */
public class NeverCaught {
    public static void main(String[] args) {
        g();
    }
    static void f() {
        throw new RuntimeException();
    }
    static void g() {
        f();
    }

}

