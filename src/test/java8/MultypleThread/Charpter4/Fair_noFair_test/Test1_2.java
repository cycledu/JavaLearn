package java8.MultypleThread.Charpter4.Fair_noFair_test;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/16:35
 * @Description :
 * @Page or WebSite：P323
 * @Expected result ：
 */
public class Test1_2 {
    public static void main(String[] args) throws InterruptedException{
        MyService service = new MyService(false);

        MyThread[] array1 = new MyThread[10];
        MyThread[] array2 = new MyThread[10];
        for (int i = 0; i < array1.length; i++) {
            array1[i]=new MyThread(service);
            array1[i].setName("array1++"+(i+1));
        }
        for (int i = 0; i < array1.length; i++) {
            array1[i].start();
        }
        for (int i = 0; i < array1.length; i++) {
            array2[i]=new MyThread(service);
            array2[i].setName("array2--"+(i+1));
        }
        Thread.sleep(500);
        for (int i = 0; i < array1.length; i++) {
            array2[i].start();
        }

    }
}
