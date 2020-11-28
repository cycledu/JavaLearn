package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/22:52
 * @Description :
 * @Page or WebSite：P196/练习9、练习10
 * @Expected result ：
 */
public class Test13 {
    public inter1 AA(){
        return new inter1(){
            @Override
            public void method() {
                System.out.println("练习13，使用匿名内部类");
            }
        };
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        inter1 aa = test13.AA();
        System.out.println(aa);
        aa.method();
    }
}
