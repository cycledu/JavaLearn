package ThinkingInJava.Charpter14;

/**
 * @Author : jingtao
 * @Data : 2020/04/07/23:13
 * @Description :
 * @Page or WebSite：322
 * @Expected result ：
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception{
        Class<FancyToy>ftClass=FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy>up=ftClass.getSuperclass();


        Object object = up.newInstance();
        System.out.println(object.getClass());
    }
}
