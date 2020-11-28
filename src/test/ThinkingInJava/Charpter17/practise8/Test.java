package ThinkingInJava.Charpter17.practise8;

/**
 * @Author : jingtao
 * @Data : 2020/05/16/23:02
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) {
        SList<String> first = new SList<>(1, "first", null);
        System.out.println(first);
        SList<String>.SListIterator<String> stringSListIterator = first.sListIterator();
        stringSListIterator.add("second");
        System.out.println(first);
        stringSListIterator.next();
        stringSListIterator.remove();
        System.out.println(first);
    }
}
