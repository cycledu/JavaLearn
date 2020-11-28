package DataStructures.linkedlist;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/10/25/21:02
 * @Description :   ʹ��������Լɪ������
 * ����һ��ͬ����boolean���飬��ԭ���������ָ��λ�ã����������ֳ��ȣ�ֱ�������ͷ��ʼ�����ж�boolean������ͬλ���Ƿ�Ϊtrue������true��Ϊ���ʹ���
 * ������һint������ÿ����boolean����ı仯ʱ������ֱ��������������ԭ���鳤����ͬʱ�˳�ѭ��
 * @PageOrWebSite��
 * @Expected result ��
 */
public class josephyUseArray {
    public static void main(String[] args) {
        boolean[] judge = new boolean[10];
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        josefy(2, 1, arr, judge);//Ԥ�ƣ�24153
    }

    private static void josefy(int step, int start, int[] arr, boolean[] judge) {
        int temp = step;
        //��start����ʼ���б���
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
