package DataStructures.leetcode.SwordToOffer.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author : jingtao
 * @Data : 2020/06/04/23:38
 * @Description :输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * @Page or WebSite：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @Expected result ：
 */
public class Test57 {
    /**
     * ------数组元素过多时执行超时
     * 第一次：遍历数组，将大于s的值剔除（将小于s的值放入list）
     * 第二次：遍历list中每个元素，循环对比，没有相加等于s的值，将元素剔除，直到找到这样一对值
     */
    public int[] twoSum(int[] nums, int target) {
        int head = 0, tail = nums.length - 1;
        while(head < tail) {
            int s=nums[head]+nums[tail];
            //s<target,则s过小，则让s增大，则左指针右移
            if (s<target)head++;
            //s>target,则s过大，则让s减小，则右指针左移
            else if(s > target) tail--;
            else return new int[] { nums[head], nums[tail] };
        }

        return new int[0];
    }
    public static void main(String[] args) {
        Test57 test57 = new Test57();
    }
}
