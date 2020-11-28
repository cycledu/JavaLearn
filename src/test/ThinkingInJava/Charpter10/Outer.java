package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/20:02
 * @Description :
 * @Page or WebSite：P191
 * @Expected result ：
 */
public class Outer {
    private String OuterString = "OuterString";
    public Inner returnInner() {
        return new Inner();
    }
    class Inner {
        String name = "InnerString";
        /**
         * P193/练习3
         */
        public void printOuterString() {
            System.out.println(OuterString);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.returnInner();
        //P192/练习3
        inner.printOuterString();
        System.out.println(inner.name);
    }
}
