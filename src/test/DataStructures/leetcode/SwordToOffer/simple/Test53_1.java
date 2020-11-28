package DataStructures.leetcode.SwordToOffer.simple;


/**
 * @Author : jingtao
 * @Data : 2020/07/18/20:56
 * @Description :统计一个数字在排序数组中出现的次数。
 * @Page or WebSite：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @Expected result ：
 */
public class Test53_1 {

    public static void main(String[] args) {
        Test53_1 test53_1 = new Test53_1();
        System.out.println(test53_1.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
    static int result = 0;
    public int search(int[] nums, int target) {
        binarysearch(nums, nums.length / 2, 0, nums.length-1, target);
        return result;
    }
    private void binarysearch(int[] nums, int mid, int head, int tail, int target) {
        if (nums[head] > target || nums[tail] < tail) return;
        //向左向右检索叠加
        if (target == nums[mid]) {
            int temp = mid;
            while (nums[mid--] == target) result++;
            mid = ++temp;
            while (nums[mid++] == target) result++;
        } else if (target > nums[mid]) {
            binarysearch(nums, (nums.length + mid) / 2, mid + 1, tail, target);
            if (mid == 0) return;
        } else binarysearch(nums, mid / 2, 0, mid, target);
    }

}
