package ThinkingInJava.Charpter10;


import ThinkingInJava.Charpter10.Test6.package1.interface1;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/23:02
 * @Description :
 * @Page or WebSite：P196/练习10
 * @Expected result ：
 */
public class Test11 {
    private class inner implements interface1 {

        @Override
        public int method1() {
            System.out.println("here");
            return 0;
        }
    }
    public inner returnInner(){
        return new inner();
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        interface1 interface1 = test11.returnInner();
        interface1.method1();
    }
}
