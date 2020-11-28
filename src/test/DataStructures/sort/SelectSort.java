package DataStructures.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-5, 5, 9, 18, 0};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {
        // ѡ������ÿ��ѭ��������С��ֵ�Ϳ�ʼ����ѭ����Ԫ�ؽ���
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // ���ָ�Сֵ�����н���
                if (arr[j] < min) {
                    min = arr[j];
                    minindex = j;
                }
            }
            // �ڲ�forѭ��������ȫ������Сֵ�ҵ�min
            // �ж��Ƿ���Ҫ����
            if (minindex != i) {
                arr[minindex] = arr[i];
                arr[i] = min;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}