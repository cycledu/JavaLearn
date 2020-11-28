package java8.MultypleThread.Charpter7.formatOk1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/19:24
 * @Description :
 * @Page or WebSite：P429
 * @Expected result ：
 */
public class DateTools {
    public static Date parse(String formatPatter, String dateString) throws ParseException {
        return new SimpleDateFormat(formatPatter).parse(dateString);
    }
    public static String format(String formatPattern, Date date) {
        return new SimpleDateFormat(formatPattern).format(date).toString();
    }
}
