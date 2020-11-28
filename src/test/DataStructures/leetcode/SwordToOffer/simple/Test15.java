package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/05/24/11:38
 * @Description :
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * d * @Page or WebSite：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @Expected result ：
 */
public class Test15 {
    //错误
    public int hammingWeight(int n) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (n >= 1) {
            if (n == (n >> 1) << 1) {
                sum = 0;
            } else
                sum = 1;
            n = n >> 1;
            sb.append(sum);
        }
        String s = sb.toString().replaceAll("0", "");
        return s.length();
    }
    /**
     * 方法一：逐位判断
     * @param n
     * @return
     */
    //从后往前依次操作，将1变成0，判断进行了多少次变化
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            /**
             * n-1：相当于将一个二进制数最右面的1变成0，该1后面的0全部变成1   1010 -> 1001
             * n&(n-1)：相当于将最右面的1变成0                           1010&1001 -> 1000
             * 每一次操作相当于从后向前，将1全部变成0的过程，进行了多少次操作就说明二进制数中有多少个1
             */
            n &= n - 1;//n=n&(n-1) :相与的过程（同1为1），
            count++;
        }
        return count;

    }
    //方法二：巧用n&(n−1)，依次判断最后一位是否为1，然后向右无符号移位
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            /**
             * n&1：若最后一位是1，则count+1，若不是1，则无变化
             * 每次循环n无符号右移一位
             */
            count+=n&1;
            n=n>>>1;
        }
        return count;

    }
    public static void main(String[] args) {
        Test15 test15 = new Test15();
        System.out.println(test15.hammingWeight2(245));
    }
}
