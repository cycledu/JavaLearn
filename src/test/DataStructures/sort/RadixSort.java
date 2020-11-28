package DataStructures.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int arr[] = { 53, 3, 542, 748, 14, 214 };
		radixsort(arr);
	}

	public static void radixsort(int arr[]) {

		// ��ȡԭ������������ֵλ��
		int figure = (arr[0] + "").length();
		for (int i = 1; i < arr.length; i++) {
			if (figure < (arr[i] + "").length())
				figure = (arr[i] + "").length();
		}
		// ����һ����ά������ΪͰ�������ȡ������ֵ(���ܻ�ƽ���ż���,ÿһλ������ʱ0-9����10�У�Ҳ����ͬʱ������һ��)
		int bucket[][] = new int[10][arr.length];
		// ����һά�����¼ÿһ�η�Ͱ��ÿһ��Ͱ���м�����ֵ
		// ���磺recode[0] , ��¼�ľ��� ��0Ͱ�ķ������ݸ���λrecode[0]��
		int[]recode = new int[10];
		// ���մӸ�λ��ʮλ��˳������ѭ������ֵ����Ͱ����ȡ��
		for (int i = 0, n = 1; i < figure; i++, n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				// ѭ����ÿ����ͨ����ĳһ��λ����λ������ֵ���ڶ�Ӧ��Ͱ��
				// ȡ��ÿ��Ԫ�ض�Ӧλ��ֵ
				int digitOfElement = arr[j] / n % 10;
				// �Ž���Ӧ��Ͱ��
				bucket[digitOfElement][recode[digitOfElement]] = arr[j];
				recode[digitOfElement]++;
			}
			// �������Ͱ��˳��(һά������±�����ȡ�����ݣ�����ԭ������)
			int index = 0;
			// ����ÿһͰ������Ͱ�������ݣ����뵽ԭ����
			for (int k = 0; k < recode.length; k++) {
				if (recode[k] != 0) { // ˵����k��λ�õ�Ͱ���� recode[k]����
					for (int j = 0; j < recode[k]; j++) {
						arr[index++] = bucket[k][j];
					}
				}
				// ����һά��¼�����ÿ��ֵȡ��Ͱ�е����󣬽�recode���㣬������һ�θ��ݾɵļ�¼��ȡ��������ֵ��λ�ã�������ָ���쳣
				recode[k] = 0;
			}
			System.out.println("��" + i + "�֣��Ը�λ�������� arr =" + Arrays.toString(arr));
		}
	}
}
