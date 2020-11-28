package ThinkingInJava.Charpter10;

import java.util.Date;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/20:43
 * @Description :
 * @Page or WebSite：P194/练习5
 * @Expected result ：
 */
public class DependenceClass {
    private OuterTest194 outerTest194;
    public DependenceClass(OuterTest194 outerTest194) {
        this.outerTest194 = outerTest194;
    }
    public OuterTest194.Inner returnInner(){
        return outerTest194.new Inner();
    }
    public static void main(String[] args) {
        OuterTest194 outerTest194 = new OuterTest194();
        DependenceClass dependenceClass = new DependenceClass(outerTest194);
        OuterTest194.Inner inner = dependenceClass.returnInner();
        System.out.println(inner.a+" "+ new Date());
    }
}
