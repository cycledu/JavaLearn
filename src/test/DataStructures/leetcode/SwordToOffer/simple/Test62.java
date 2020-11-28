package DataStructures.leetcode.SwordToOffer.simple;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/06/03/22:53
 * @Description :
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * @Page or WebSite：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @Expected result ：
 */
public class Test62 {
    public int lastRemaining(int n, int m) {
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i;
        }
        return deleteMnum(ints, m);
    }

    private int deleteMnum(int[] arr, int m) {
        Stack<Integer> stack = new Stack<>();
        boolean isVisted[] = new boolean[arr.length];
        int start = 0;
        int step = m;
        while (true) {
            if (stack.size() == arr.length) {
                return stack.pop();
            }
            for (; start < step; start++) {
                if (start >= arr.length) start = 0;
                if (step >= arr.length) step = 0;
                if (isVisted[start]) {
                    step++;
                }
                start++;
            }
            if (!isVisted[start]){
                isVisted[start]=true;
            }
            stack.push(start);

        }
    }

    @Test
    public void test() {
        System.out.println(lastRemaining(5, 3));
    }

}
