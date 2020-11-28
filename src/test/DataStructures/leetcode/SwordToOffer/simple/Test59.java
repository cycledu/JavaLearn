package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/06/16/23:14
 * @Description :面试题59 - I. 滑动窗口的最大值
 * @Page or WebSite：
 * @Expected result ：
 */

import java.util.Arrays;

/**
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class Test59 {
    public int[] method1(int[] nums, int k) {
        if (nums.length <= k) {
            Arrays.sort(nums);
            return new int[]{nums[0]};
        }
        int[] maxArray = new int[nums.length - k + 1];
        int a = 0;
        int index;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int temp=i;
            //找出最大数
            index=i;
            for (int j = i; j < i+k; j++) {
                if (nums[j]<nums[j+1]){
                    index++;//如果后面的数比前面的数大，
                }
            }
//            maxArray[a++] = nums[i] > nums[i + 1] ? (nums[i] > nums[i + 2] ? nums[i] : nums[i + 2]) : (nums[i + 1] > nums[i + 2] ? nums[i + 1] :
//                    nums[i + 2]);
            //判断最大值是否是该次窗口中第一个元素，如果不是，则要与一下次窗口中的新元素直接比较
            //if 非第一个数最大  index=i；
        }
        return maxArray;
    }
}
