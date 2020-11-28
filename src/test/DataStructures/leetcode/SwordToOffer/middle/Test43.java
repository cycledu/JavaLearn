package DataStructures.leetcode.SwordToOffer.middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/07/26/17:46
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test43 {
    //超出时间限制
    public int countDigitOne(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(String.valueOf(i));
        String reduce = list.stream().map(v -> v.replaceAll("[^1]", "")).reduce("", String::concat);
        return reduce.length();
    }
    @Test
    public void test(){
        System.out.println(countDigitOne(12));
    }

    public int countDigitOne1(int n) {
        int num=0;

        return 0;
    }

}
