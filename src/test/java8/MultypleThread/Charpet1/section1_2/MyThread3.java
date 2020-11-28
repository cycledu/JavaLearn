package java8.MultypleThread.Charpet1.section1_2;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/19:18
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class MyThread3 extends Thread {
    private int i;
    public MyThread3(int i){
        this.i=i;
    }
    @Override
    public void run() {
        System.out.println(i);
    }
}
