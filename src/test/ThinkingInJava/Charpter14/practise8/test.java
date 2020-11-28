package ThinkingInJava.Charpter14.practise8;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/05/11/22:18
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
class A {
}
class B extends A {
}
class C extends B {
    String A;
    int I;
    double D;
    List list;
}
class D extends C {
}
public class test {
    public static void judge(Object o) throws Exception {
        Class<?> superclass = o.getClass().getSuperclass();
        if (o.getClass().getDeclaredFields().length > 0) {
            System.out.println("其中的域：");
            Field[] declaredFields = o.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                //获取成员变量的类型
                System.out.print("------------"+field.getType().getName()+" ");
                //获取成员变量的名称
                System.out.println(field.getName());
            }
            System.out.println();
        }
        System.out.println(superclass);

        if (!(superclass.getSimpleName().equals("Object"))) {
            judge(superclass.newInstance());
        }

    }
    public static void main(String[] args) throws Exception {
        D d = new D();
        judge(d);
    }
}
