package java8.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

/**
 * @Author : jingtao
 * @Data : 2020/08/02/0:00
 * @Description :jodaTime����
 * @Page or WebSite��
 * @Expected result ��
 */
public class jodaTest {

    @Test
    public void test(){
        DateTime dateTime = new DateTime();//����
        DateTime plus = dateTime.plus(1);//��һ��
        System.out.println(plus.toString("yyyy-MM-dd"));

        LocalDate localDate = new LocalDate();
        System.out.println(localDate);
        LocalDate localDate1 = localDate.plusMonths(3).dayOfMonth().withMinimumValue();
        System.out.println(localDate1);
        //��������ǰ�����������һ�������
        DateTime dateTime1 = new DateTime();
        DateTime dateTime2 = dateTime.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMinimumValue();
        System.out.println(dateTime2.toString("yyyy-MM-dd"));
    }

    @Test
    public void test1(){

    }
}
