package DataStructures.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-5, 5, 9, 18, 0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];//����ǰҪ�������б��в����ֵ������ʱ����
            int insertIndex = i - 1;//��ʾ�����б�����Ԫ���±꣬ͬʱҲ��������ֵ��ʼ��ǰ���бȽϵ���ʼ�±�

            //�������ֵ��С��0��������ֵ����������ֵСʱ��insertIndex��1�����Ƚ�,
            //ֱ���ҵ�ĳһ����������ֵС��ѭ���Ƚϵ�temp�������Ѿ�Ϊ0����˵��temp��ֵ�ҵ����ʵĲ���Ϊֵ
            while (insertIndex >= 0 && temp < arr[insertIndex]) {
                //������������insertIndex��ֵ��temp����tmepλ�õ�ֵ����ΪinsertIndexλ�õ�ֵ���൱����������ıȵ�ǰԪ�ؽϴ������ƶ�һ��λ�ã�
                arr[insertIndex + 1] = arr[insertIndex];//insertIndex+1������һ��ѭ����i��ֵ�����ǲ���ֱ��ʹ��i�����Լ���Ӱ�����
                insertIndex--;
            }
            //��ʱ����temp���������λ�ã��˳�whileʱ��temp���ҵ���Ҫ�����λ�ã�
            arr[insertIndex + 1] = temp;
        }
    }
}
