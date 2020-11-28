package DataStructures.leetcode.SwordToOffer.simple;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/07/18/17:16
 * @Description :写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
 * @Page or WebSite：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @Expected result ：
 */
public class Test10_1 {
    static int num = 1;
    private static int fib(int n) {
        int one = 0, two = 1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int fibonacci = fibonacci(one, two, n);
        return fibonacci % 1000000007;
    }
    private static int fibonacci(int zero, int one, int i) {
        if (num >= i) return one;
        int two = zero + one;
        num++;
        return fibonacci(one, two, i);
    }
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    @Test
    public void fib1() {
        int n=30;
        int[] ints = new int[n];
        ints[0]=0;
        ints[1]=1;
        for (int i = 2; i < n; i++) {
            ints[i]=ints[i-1]+ints[i-2];
        }
        System.out.println(Arrays.toString(ints));
    }


}
