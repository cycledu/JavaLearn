package DataStructures.linkedlist;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/10/25/21:02
 * @Description :   使用数组解决约瑟夫问题
 * 创建一个同长度boolean数组，在原数组递增到指定位置（递增到数字长度，直接置零从头开始），判断boolean数组相同位置是否为true（这里true意为访问过）
 * 定义另一int并随着每次有boolean数组的变化时递增，直到变量递增到与原数组长度相同时退出循环
 * @PageOrWebSite：
 * @Expected result ：
 */
public class josephyUseArray {
    public static void main(String[] args) {
        boolean[] judge = new boolean[10];
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        josefy(2, 1, arr, judge);//预计：24153
    }

    private static void josefy(int step, int start, int[] arr, boolean[] judge) {
        int temp = step;
        //从start处开始进行遍历
        int i = -1;
        i = start + i;
        int sum = 0;
        while (true) {
            for (int j = 1; j < temp; j++) {
                i++;
                if (i == arr.length) i = 0;
                if (judge[i] == true) temp++;
            }
            temp = step;
            if (!judge[i]) {
                judge[i] = true;
                sum++;
                System.out.println(arr[i]);
                if (sum == arr.length) break;
            }
            while (true) {
                i++;
                if (i == arr.length) i = 0;
                if (judge[i] == false) break;
            }
        }
    }
}
