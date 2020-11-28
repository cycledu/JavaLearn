package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/21:07
 * @Description :
 * @Page or WebSite：P195/练习7；内部类访问外部类私有元素及私有方法
 * @Expected result ：
 */
abstract class inner{}
public class Test12 {
    private String a = "a";
    private void print() {
        System.out.println("外部私有方法");
    }
    public inner returninner() {
        return new inner() {
            {
                a = "修改后";
                print();
                System.out.println(a);
            }
        };
    }
    public static void main(String[] args) {
        Test12 test12 = new Test12();
        inner returninner = test12.returninner();
    }
}
