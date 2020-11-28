package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/22:52
 * @Description :
 * @Page or WebSite：P196/练习9、练习10
 * @Expected result ：
 */
public class Test9 {
    public inter1 AA(){
        class inner implements inter1{
            @Override
            public void method() {
                System.out.println("AA方法内部的内部类实现接口的方法");
            }
        }
        return new inner();
    }

    public inter1 BB(){
        if (true){
            class inner implements inter1{
                @Override
                public void method() {
                    System.out.println("BB方法内部的内部类实现接口的方法");
                }
            }
            return new inner();
        }
        return null;
    }

    public static void main(String[] args) {
        Test9 test9 = new Test9();
        inter1 aa = test9.AA();
        inter1 bb = test9.BB();
//        System.out.println(aa);
//        aa.method();
        bb.method();
    }
}
interface inter1{
    void method();
}
