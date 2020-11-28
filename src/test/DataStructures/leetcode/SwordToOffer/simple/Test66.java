package DataStructures.leetcode.SwordToOffer.simple;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/07/15/23:51
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test66 {
    @Test
    public static int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = getResult(a, i);
        }
        return b;
    }
    private static int getResult(int[] a, int i) {
        int result = 1;
        for (int j = 0; j < a.length; j++) {
            if (i != j) result *= a[j];
        }
        return result;
    }
    public static void main(String[] args) {
        constructArr(new int[]{1, 2, 3, 4, 5});
    }
}
