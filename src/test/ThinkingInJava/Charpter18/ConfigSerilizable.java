package ThinkingInJava.Charpter18;

import java.io.*;

/**
 * @Author : jingtao
 * @Data : 2020/07/11/18:52
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class ConfigSerilizable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serialobject a = new Serialobject("A", 1);
        String filename = "G:\\Learn\\JavaSourceLearn\\src\\toolTest\\ThinkingInJava\\Charpter18\\ConfigSerilizable.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(a);
        //oos.close();
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Serialobject object = (Serialobject) ois.readObject();
        System.out.println(object);
//        int i = ois.readInt();
//        System.out.println(object);
    }
}
