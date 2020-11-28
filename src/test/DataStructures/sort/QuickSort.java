package DataStructures.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 9, 9, 2, 1, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left; // ���±�
        int r = right; // ���±�
        // pivot ����ֵ
        int pivot = arr[(left + right) / 2];
        int temp = 0; // ��ʱ��������Ϊ����ʱʹ��
        /**
         * ���������м����α�����������ҵ���pivotλ�ô��ֵ���ұ��ҵ���pivotλ��С��ֵʱͣס����������ֵ
         */
        // whileѭ����Ŀ�����ñ�pivot ֵС�ŵ����
        // ��pivot ֵ��ŵ��ұ�
        while (l < r) {
            // ��pivot�����һֱ��,�ҵ����ڵ���pivotֵ,���˳�
            while (arr[l] < pivot) {
                l += 1;
            }
            // ��pivot���ұ�һֱ��,�ҵ�С�ڵ���pivotֵ,���˳�
            while (arr[r] > pivot) {
                r -= 1;
            }
            // ���l >= r˵��pivot ����������ֵ���Ѿ��������ȫ����С�ڵ���pivotֵ���ұ�ȫ���Ǵ��ڵ���pivotֵ
            if (l >= r) {
                break;
            }
            // ����
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // ���������󣬷������arr[l] == pivotֵ ��� r--�� ǰ��
            if (arr[l] == pivot) {
                r -= 1;
            }
            // ���������󣬷������arr[r] == pivotֵ ��� l++�� ����
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        // ��� l == r��l��rλ��ͬһλ�ã�, ����l--, r++, ����Ϊ����ջ���
        if (l == r) {
            l -= 1;
            r += 1;
        }
        // ����ݹ�
        if (left < r) {
            quickSort(arr, left, l);
        }
        // ���ҵݹ�
        if (right > l) {
            quickSort(arr, r, right);
        }

    }
}
