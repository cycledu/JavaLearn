package java8.MultypleThread.Charpter6.singleton_7_1;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/15:20
 * @Description :
 * @Page or WebSite：P400
 * @Expected result ：
 */
public class MyObject implements Serializable {
    private static final long serialVersionUID = 888L;
    public static Userinfo userinfo = new Userinfo();
    private static MyObject myObject = new MyObject();
    private MyObject() {

    }
    public static MyObject getInstance() {
        return myObject;
    }
    //readEesolve方法的作用式反序列化时不创建新的对象，而是复用原有的对象
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法");
        return MyObject.myObject;
    }
}
