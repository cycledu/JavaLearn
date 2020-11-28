package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/05/23/18:29
 * @Description :
 * @Page or WebSite：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @Expected result ：
 */
public class Test10_2 {
    //错误
    public int numWays(int n) {
        int num = 0;
        if (n == 0) return 0;
        for (int i = 1; i <= n; i++) {
            if (!Double.toString((n - i) / 2).contains(".5")) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Test10_2 test10_2 = new Test10_2();
        System.out.println(test10_2.numWays2(46));
    }

    public int numWays2(int n) {
        //T[n]=T[n-1]+T[n-2]
        //T[0]=0
        //T[1]=1
        //T[2]=2
        if (n == 0 || n == 1) return 1;

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n] % 1000000007;
    }
}
