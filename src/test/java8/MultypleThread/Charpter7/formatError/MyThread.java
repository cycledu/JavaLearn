package java8.MultypleThread.Charpter7.formatError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/19:10
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class MyThread extends Thread {
    private SimpleDateFormat sdf;
    private String dateString;
    public MyThread(SimpleDateFormat sdf, String dateString) {
        this.sdf = sdf;
        this.dateString = dateString;
    }
    @Override
    public void run() {
        try {
            Date dateRef = sdf.parse(dateString);
            String newDateString = sdf.format(dateRef);
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName=" + this.getName() + "报错了，日期字符串：" + dateString + "转换成的日期为：" + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
