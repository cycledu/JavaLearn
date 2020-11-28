package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/05/21/22:05
 * @Description :
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * @Page or WebSite：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @Expected result ：
 */
public class Test51 {
    //暴力解法：当数组中元素过多时，执行超时
    public int reversePairs(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] > nums[j]) {
                    num++;
                }
                j++;
            }
        }
        return num;
    }
    public static void main(String[] args) {
        Test51 test51 = new Test51();
        System.out.println(test51.reversePairs(new int[]{7, 5, 6, 4}));
    }
}
