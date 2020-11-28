package ThinkingInJava.Charpter18;


import java.io.*;

/**
 * @Author : jingtao
 * @Data : 2020/07/11/18:46
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class Serialobject implements Serializable {
    final static long serialVersionUID=4322624626L;
    public String a;
    public transient int i;
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public Serialobject() {
    }
    public Serialobject(String a, int i) {
        this.a = a;
        this.i = i;
    }
    //writeObject和readObject实现自定义序列化和反序列化(两个方法必须成对出现)
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.writeInt(i);
        stream.writeObject(null);
    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        this.a = String.valueOf(stream.readObject());
        this.i = stream.readInt();
    }
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
    @Override
    public String toString() {
        return "object{" + "a='" + a + '\'' + ", i=" + i + '}';
    }
//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeInt(100);
//        out.writeObject(a);
//    }
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        i=in.readInt();
//        a= String.valueOf(in.readObject());
//    }
}
