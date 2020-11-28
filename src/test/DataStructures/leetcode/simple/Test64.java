package DataStructures.leetcode.simple;

import org.junit.Test;

/**
 * @Author : jingtao
 * @Data : 2020/07/25/19:28
 * @Description :求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test64 {
    @Test
    public void test() {
        System.out.println(sumNums(5));
    }

    int[] test = new int[]{0};

    public int sumNums(int n) {
        try {
            return test[n];
        } catch (Exception e) {
            return n + sumNums(n - 1);
        }
    }

    @Test
    public int sumNums2(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
