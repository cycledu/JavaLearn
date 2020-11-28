package DataStructures.leetcode.MyTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/11/18/10:46
 * @Description :
 * @PageOrWebSite£∫
 * @Expected result £∫
 */
public class test {
    @Test
    public void test20() {
        System.out.println(hammingWeight(9));
        System.out.println(hammingWeight2(31));
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res++;//resœ»º”1
            n &= n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }

    @Test
    public void testReference() {
        List list = new ArrayList<Integer>();
        list.add(1);
        changlist(list);
        System.out.println(list);
    }

    private void changlist(List list) {
        list.add(2);
    }

}
