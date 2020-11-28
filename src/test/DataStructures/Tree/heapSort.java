package DataStructures.Tree;

import java.util.Arrays;

public class heapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapsort(arr);
        String string = "�й��Java���ģʽ����˳ƽͼ��java���ģʽ - 85.";
        System.out.println(string.length());
    }

    // �����򷽷�
    public static void heapsort(int[] arr) {
        int temp = 0;
        System.out.println("������!!");

        //�����һ����Ҷ�ӽ�㿪ʼ����ǰ��ʼ�����󶥶�
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            //����
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("����=" + Arrays.toString(arr));
    }

    /**
     * ���������ɴ󶥶ѵķ���
     *
     * @param arr    ������������
     * @param i      ��ʼ�����������Ӧ�������з�Ҷ�ӽ���Ԫ��λ��
     * @param length ��������Ҫ������Ԫ�ظ����� ��Ϊÿһ�ε��õ�������֮�����򷽷��Ὣ����ֵ����ŵ�������� ��Ҫ�����Ԫ�ظ��������μ���
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        // ������ʱ������ŷ�Ҷ�ӽ���ֵ
        int temp = arr[i];
        // ����i�£�����֮��iλ�õĽڵ�������¶������������ҳ��������б�iλ�õ�ֵ����������н���
        // j*2+1��ʾ���������Ӧ���������ӽ����бȽ�,��Ϊj�����ӽ���λ������j*2+1
        for (int j = i * 2 + 1; j < arr.length; j = j * 2 + 1) {
            // i�����ӽ���ֵ�Ƿ�������ӽ���ֵ
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;// jָ�����ӽ��
            }
            // ���ӽ��������ֵ�͸����iλ�õ�ֵ���бȽ�
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j; // !!! i ָ�� j,����ѭ���Ƚϣ��������ӽ��Ϊ���������Ĵ󶥶ѱȽϸ�ֵ��
            } else {
                break;
            }
        }
        // ��for ѭ�������������Ѿ�����i Ϊ�������������ֵ�������� �(�ֲ�)
        arr[i] = temp;// ��tempֵ�ŵ��������λ��
    }
}
