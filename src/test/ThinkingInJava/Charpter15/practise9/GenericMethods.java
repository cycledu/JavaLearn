package ThinkingInJava.Charpter15.practise9;

/**
 * @Author : jingtao
 * @Data : 2020/05/13/22:59
 * @Description :
 * @Page or WebSite：P361/练习9
 * @Expected result ：
 */
public class GenericMethods {
    public <T,M> void f(T t,M m,Double h){
        System.out.println("t的类型是："+t.getClass().getName());
        System.out.println("m的类型是："+m.getClass().getName());
        System.out.println("h的类型是："+h.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f("",1,0.8);
    }
}
