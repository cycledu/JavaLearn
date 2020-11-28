package java8.MultypleThread.Charper3.TwoThreadTransData.mylist;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/22:48
 * @Description :
 * @Page or WebSite：P190
 * @Expected result ：
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
