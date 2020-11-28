package ThinkingInJava.Charpter14.practise10;

/**
 * @Author : jingtao
 * @Data : 2020/05/11/22:59
 * @Description :
 * @Page or WebSite：P318
 * @Expected result ：
 */

public class test {
    public static void main(String[] args) {
        char[] tChar = {'a', 'b', 'c'};

        if (tChar.getClass() != null) {//getClass() 返回此 Object 的运行时类

            System.out.println("It is an Object");
        }
    }
}
