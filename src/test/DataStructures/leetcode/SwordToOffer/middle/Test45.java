package DataStructures.leetcode.SwordToOffer.middle;

import org.junit.Test;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/07/30/23:30
 * @Description : 把数组排成最小的数
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test45 {
    public String minNumber(int[] nums) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.addAll(Arrays.asList(Integer.toString(nums[i]).split("")));
        }
        list.sort(String::compareTo);
        if (list.get(0).equals("0")) {
            int i = 0;
            while (list.get(i).equals("0")) {
                i++;
            }
            list.set(0, list.get(i));
            list.set(i, "0");
        }
        System.out.println(list);
        String reduce = list.stream().reduce("", String::concat);
        return reduce;
    }

    @Test
    public void test() {
        System.out.println(minNumber(new int[]{20, 1}));
    }
}