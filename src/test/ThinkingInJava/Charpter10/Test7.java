package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/21:07
 * @Description :
 * @Page or WebSite：P195/练习7；内部类访问外部类私有元素及私有方法
 * @Expected result ：
 */
public class Test7 {
    private String a = "a";
    private void print() {
        System.out.println("外部私有方法");
    }
    public void returninner() {
        new inner().change();
    }
    class inner {
        public void change() {
            a = "修改后";
            print();
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        Test7 test7 = new Test7();
        test7.returninner();
    }
}
