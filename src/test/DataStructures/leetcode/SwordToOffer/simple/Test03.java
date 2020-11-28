package DataStructures.leetcode.SwordToOffer.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : jingtao
 * @Data : 2020/05/19/23:03
 * @Description :找出数组中重复的数字。
 * @Page or WebSite：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @Expected result ：
 */
public class Test03 {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 5, 45, 4, 5}));
    }
    //逻辑比较繁琐，所以速度慢
    public static int findRepeatNumber(int[] nums) { //15ms
        int n = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //若存在，则返回这个重复的数，不存在就加进去
            if (set.contains(nums[i])) {
                n = nums[i];
                break;
            } else {
                set.add(nums[i]);
            }
        }
        return n;
    }
    public static int officialSolution(int[] nums) {  //6ms
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {//set.add(num)直接判断是否添加成功，如果哪一次没有添加成功，则说明这一次的数时重复的
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
