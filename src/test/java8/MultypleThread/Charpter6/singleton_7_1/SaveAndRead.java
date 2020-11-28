package java8.MultypleThread.Charpter6.singleton_7_1;

import java.io.*;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/15:25
 * @Description :
 * @Page or WebSite：P401
 * @Expected result ：
 */
public class SaveAndRead {
    public static void main(String[] args) {
        try {
            MyObject myObject = MyObject.getInstance();
            System.out.println("序列化-myObject=" + myObject.hashCode() + ",userinfo=" + myObject.userinfo.hashCode());
            FileOutputStream fosRef = new FileOutputStream(new File("myObject.txt"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObject);
            oosRef.close();
            fosRef.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fisRef = new FileInputStream(new File("myObject.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            MyObject myObject = (MyObject) iosRef.readObject();
            iosRef.close();
            fisRef.close();
            System.out.println("序列化-myObject=" + myObject.hashCode() + " userinfo=" + myObject.userinfo.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
