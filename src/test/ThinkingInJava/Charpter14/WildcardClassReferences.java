package ThinkingInJava.Charpter14;

/**
 * @Author : jingtao
 * @Data : 2020/04/07/23:03
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?>intClass=int.class;
        intClass=double.class;
    }
}
