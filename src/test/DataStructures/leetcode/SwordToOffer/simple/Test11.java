package DataStructures.leetcode.SwordToOffer.simple;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/05/23/11:51
 * @Description :
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * @Page or WebSite：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @Expected result ：
 */
public class Test11 {
    //未正确理解题意
    public int minArray(int[] numbers) {
        int minIndex = 0, i = 0, k = 0;
        int[] ints = new int[numbers.length];
        while (numbers[i] > numbers[++i])
            minIndex = i;
        int[] ints1 = Arrays.copyOfRange(numbers, minIndex, numbers.length);
        for (int j = 0; j < ints1.length; j++) {
            ints[j] = ints1[j];
        }
        for (int j = 0; j < minIndex; j++) {
            ints[k++] = numbers[j];
        }
        return minIndex;
    }

    public int minArray1(int[] numbers) {
        int minIndex = 0, i = 0;
        if (numbers.length == 1) {
            return numbers[0];
        }
        while (i < numbers.length - 1)
            if (numbers[i] > numbers[++i]) {
                minIndex = i;
                if (minIndex == numbers.length)
                    return numbers[0];
            }
        return numbers[minIndex];
    }
    //使用二分法进行查找，比遍历效率更高
    //https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
    class Solution {
        public int minArray(int[] numbers) {
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                int m = (i + j) / 2;
                if (numbers[m] > numbers[j]) i = m + 1;
                //numbers[m] < numbers[j] 则还没有找到数组中的最大值，根据所给数组的规律，左面子数组的最后一个值一定比右面子数组的所有值都大
                else if (numbers[m] < numbers[j]) j = m;
                else j--;
            }
            return numbers[i];
        }
    }
}
