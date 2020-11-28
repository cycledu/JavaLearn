package java8.MultypleThread.Charpter6.singleton_7;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/15:00
 * @Description :
 * @Page or WebSite：P399
 * @Expected result ：
 */
//静态内部类实现单例的原理
//https://blog.csdn.net/mnb65482/article/details/80458571?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1
public class MyObject {
    //内部类方式
    //静态内部类的优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。
    // 即当SingleTon第一次被加载时，并不需要去加载SingleTonHoler，
    //          只有当getInstance()方法第一次被调用时，才会去初始化INSTANCE,
    // 第一次调用getInstance()方法会导致虚拟机加载SingleTonHoler类，
    //          这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }
    private MyObject() {

    }
    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }
}
