package DataStructures.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5, -6, 4, 0, 8};
        boolean flag = false;//��ʾ�Ƿ���й����򽻻�,�жϲ�����ѭ��������������ıȽ�
        int temp = 0;
        // ����ÿ�ν��������ŵ����
        for (int j = 0; j < arr.length - 1; j++) {

            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    //�����ǰ��������һ�������򽻻�
                    flag = true;
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
            if (!flag) {//��һ�������У�һ�ν�����û�з�������û�г��ֹ�һ��������һ������������
                break;
            }
        }
        System.out.println("�����");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
