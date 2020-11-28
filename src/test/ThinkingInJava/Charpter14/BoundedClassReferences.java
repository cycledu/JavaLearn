package ThinkingInJava.Charpter14;

/**
 * @Author : jingtao
 * @Data : 2020/04/07/23:04
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number>bounded=int.class;
        bounded=double.class;
        bounded=Number.class;
    }
}
