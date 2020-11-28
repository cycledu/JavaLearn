package ThinkingInJava.Charpter10.Test6.package2;


import ThinkingInJava.Charpter10.Test6.package1.interface1;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/21:25
 * @Description :
 * @Page or WebSite：P195:练习6
 * @Expected result ：
 */
public class Outer {
    protected class inner
            implements interface1
    {
        //此处必须有构造方法，如果不定义构造方法，则编译器自动生成与类的访问权限相同的默认构造方法。
        //若使用编译器生成的protected权限的构造器，子类将不能创建protected内部类的实例
        //  https://blog.csdn.net/weixin_34138377/article/details/85930145
        public inner() {
        }
        @Override
        public int method1() {
            return 0;
        }
    }
}
