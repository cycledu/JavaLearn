package java8.time;

import org.junit.Test;

import java.time.LocalDate;

/**
 * @Author : jingtao
 * @Data : 2020/08/02/15:47
 * @Description :
 * @Page or WebSite��
 * @Expected result ��
 */
public class TimeTest {
    @Test
    public void test() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getYear() + "," + now.getMonthValue() + "," + now.getDayOfMonth());

        LocalDate of = LocalDate.of(2018, 3, 4);
        System.out.println(of);
    }
}
