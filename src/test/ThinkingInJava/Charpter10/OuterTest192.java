package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/20:15
 * @Description :
 * @Page or WebSite：P192/练习2
 * @Expected result ：
 */
public class OuterTest192 {
    String a;
    public OuterTest192(String a) {
        this.a = a;
    }
    @Override
    public String toString() {
        return "OuterTest192{" +
                "a='" + a + '\'' +
                '}';
    }
    public class Sequence{
        private String[] stringArray;

    }
}
