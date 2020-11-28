package java8.MultypleThread.Charpter7.formatError;


import java.text.SimpleDateFormat;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/19:14
 * @Description :
 * @Page or WebSite：P427
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray = {"2020-01-01", "2000-01-01", "2000-01-03", "2000-01-04", "2000-01-05", "2000-01-06", "2000-01-07",
                "2000-01-08", "2000-01-09", "2000-01-10"};
        MyThread[] threadArray = new MyThread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new MyThread(sdf, dateStringArray[i]);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
