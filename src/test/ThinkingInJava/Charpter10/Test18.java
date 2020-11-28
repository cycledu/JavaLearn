package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/22:28
 * @Description :
 * @Page or WebSite：P202/练习18
 * @Expected result ：
 */
public class Test18 {
    public static class inner{
        String innerString="inner";
    }

    public static void main(String[] args) {
        //创建嵌套类对象，无需访问外围类对象
        inner inner = new inner();
        System.out.println(inner.innerString);
    }
}
