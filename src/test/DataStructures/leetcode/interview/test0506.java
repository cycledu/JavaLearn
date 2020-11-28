package DataStructures.leetcode.interview;

import org.junit.Test;

/**
 * @Author : jingtao
 * @Data : 2020/11/24/17:49
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class test0506 {

    public static void main(String[] args) {
        System.out.println(test1(29, 15));
        System.out.println(test2(29, 15));
    }

    public static int test1(int A, int B) {
        int sum = 0;
        int temp = A ^ B;
        while (temp != 0) {
            sum += 1;
            temp &= temp - 1; //对异或的结果进行与操作，循环可获得1的个数
        }
        return sum;
    }


    public static int test2(int A, int B) {
        int sum = 0;
        int temp = A ^ B;
        while (temp != 0) {
            int i = temp >>> 1 << 1;
            if (temp != i)
                sum++;
            temp >>>= 1;
        }
        return sum;
    }
}
