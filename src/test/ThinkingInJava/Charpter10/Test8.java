package ThinkingInJava.Charpter10;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/21:19
 * @Description :
 * @Page or WebSite：P195:练习8：外部类是否可以访问内部类的private元素
 * @Expected result ：
 */
public class Test8 {

    class inner{
        private String string="内部类私有元素";
    }

    void returninner(){
        inner inner = new inner();
        System.out.println(inner.string);
    }
    public static void main(String[] args) {
        Test8 test8 = new Test8();
        test8.returninner();
    }
}
