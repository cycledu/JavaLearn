package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/22:31
 * @Description :
 * @Page or WebSite：P202/练习19
 * @Expected result ：
 */
public class Test19 {
    public static class inner {
        public static class innerofinner {
            String innerofinner = "innerofinner";
        }
    }

    public static void main(String[] args) {
        inner.innerofinner innerofinner = new inner.innerofinner();

    }
}
