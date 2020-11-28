package DataStructures.leetcode.SwordToOffer.simple;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/05/25/22:10
 * @Description :
 * 实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * @Page or WebSite：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @Expected result ：
 */
public class Test21 {
    public int[] exchange(int[] nums) {
        int pre = 0, post = nums.length - 1, temp = 0;
        while (pre < post) {
            if (nums[pre] != ((nums[pre] >> 1) << 1)) {  //说明前指针指向的不是偶数
                pre++;
                continue;
            }
            if (nums[post] == ((nums[pre] >> 1) << 1)) {//说明后指针指向的不是奇数
                post--;
                continue;
            }
            temp = nums[pre];
            nums[pre] = nums[post];
            nums[post] = temp;
        }
        return nums;
    }
    //首位双指针
    public int[] exchange1(int[] nums) {
        int pre = 0, post = nums.length - 1, temp = 0;
        while (pre < post) {
            if ((nums[pre] & 1) != 0) {  //说明前指针指向的不是偶数
                pre++;
                continue;
            }
            if ((nums[post] & 1) == 0) {//说明后指针指向的不是奇数
                post--;
                continue;
            }
            temp = nums[pre];
            nums[pre] = nums[post];
            nums[post] = temp;
        }
        return nums;
    }
    //快慢指针
    public int[] exchange2(int[] nums) {
        int slow = 0, fast = 0, temp = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) != 0) {//说明nums[fast]是奇数，则交换两个数
                temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                //将慢索引前移
                slow++;
            }
            //每次循环都将快索引前移
            fast++;
        }
        return nums;
    }
    public static void main(String[] args) {
        Test21 test21 = new Test21();
        System.out.println(Arrays.toString(test21.exchange2(new int[]{1, 2, 3, 4, 6, 54, 57, 3,
                54, 7})));
    }
}
