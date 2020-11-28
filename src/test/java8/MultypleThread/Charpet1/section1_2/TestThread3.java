package java8.MultypleThread.Charpet1.section1_2;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/19:19
 * @Description :
 * @Page or WebSite：P12/1.2.4
 * @Expected result ：
 */
public class TestThread3 {
    public static void main(String[] args) {
        MyThread3 myThread31 = new MyThread3(1);
        MyThread3 myThread32 = new MyThread3(2);
        MyThread3 myThread33 = new MyThread3(3);
        MyThread3 myThread34 = new MyThread3(4);
        MyThread3 myThread35 = new MyThread3(5);
        MyThread3 myThread36 = new MyThread3(6);
        MyThread3 myThread37 = new MyThread3(7);
        MyThread3 myThread38 = new MyThread3(8);
        MyThread3 myThread39 = new MyThread3(9);
        MyThread3 myThread310 = new MyThread3(10);
        MyThread3 myThread311 = new MyThread3(11);
        MyThread3 myThread312 = new MyThread3(12);
        MyThread3 myThread313 = new MyThread3(13);

        myThread31.start();
        myThread32.start();
        myThread33.start();
        myThread34.start();
        myThread35.start();
        myThread36.start();
        myThread37.start();
        myThread38.start();
        myThread39.start();
        myThread310.start();
        myThread311.start();
        myThread312.start();
        myThread313.start();

    }
}
