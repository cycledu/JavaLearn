package DataStructures.leetcode.SwordToOffer.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : jingtao
 * @Data : 2020/05/30/21:39
 * @Description :
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * @Page or WebSite：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @Expected result ：
 */
//1、遍历数组并统计元素的值出现的个数，使用HashMap
//2、将数组内元素进行排序，数组中若有超过数组长度一半的数组，则 （array.length-1）/2 位置上的值一定就是这个数
//3、摩尔投票法？？？
public class Test39 {
    public static void main(String[] args) {
        majorityElement1(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
    }
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int console = 0;
        for (Integer i : nums) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
            if (map.get(i) > nums.length/2) {
                console = i;
            }
        }
        System.out.println(map);
        System.out.println(console);
        return console;
    }

    public static int majorityElement1(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int temp=nums[i];
                if (nums[i]>nums[j]){
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums[nums.length/2];
    }

    public static int majorityElement2(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int temp=nums[i];
                if (nums[i]>nums[j]){
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums[nums.length/2];
    }


}
