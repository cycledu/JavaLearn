package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/22:35
 * @Description :
 * @Page or WebSite：P203/练习20
 * @Expected result ：
 */
public interface Test20 {
    void method();

    public class Inner implements Test20 {
        @Override
        public void method() {
            System.out.println("接口内嵌套类实现外部接口");
        }
        //练习21
        public static void met(Test20 test20) {
            test20.method();
        }
    }

    public static void main(String[] args) {
        Test20 inner = new Inner();
        Inner.met(inner);

        inner.method();
    }
}
