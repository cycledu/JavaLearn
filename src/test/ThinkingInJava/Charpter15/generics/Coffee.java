package ThinkingInJava.Charpter15.generics;

/**
 * @Author : jingtao
 * @Data : 2020/04/09/20:46
 * @Description :
 * @Page or WebSite：358
 * @Expected result ：
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
} ///:~

