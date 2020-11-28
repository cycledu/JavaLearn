package java8.MultypleThread.Charpter7.formatOK2;

import java.text.SimpleDateFormat;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/19:24
 * @Description :
 * @Page or WebSite：P429
 * @Expected result ：
 */
public class DateTools {
    private static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>();
    public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
        SimpleDateFormat sdf = null;
        sdf = t1.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(datePattern);
            t1.set(sdf);
        }
        return sdf;
    }
}
