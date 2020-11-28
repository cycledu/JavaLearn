package ThinkingInJava.Charpter14;

/**
 * @Author : jingtao
 * @Data : 2020/04/07/23:00
 * @Description :
 * @Page or WebSite：320
 * @Expected result ：
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass=int.class;
        Class<Integer>genericIntClass=int.class;
        genericIntClass=int.class;
        intClass=double.class;
//        Class<Number>genericNumberClass=int.class;
    }
}
