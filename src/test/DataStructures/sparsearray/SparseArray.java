package DataStructures.sparsearray;

public class SparseArray {
	public static void main(String[] args) {
		// ����ԭʼ���飬��Ϊ�丳��Чֵ
		// 1��ʾ���ӣ�2��ʾ����
		int chessArr[][] = new int[8][8];
		chessArr[2][3] = 1;
		chessArr[3][6] = 2;
		System.out.println("ԭʼ���飺");
		for (int[] c : chessArr) {
			for (int d : c) {
				System.out.printf("%d\t", d);
			}
			System.out.println();
		}

		// ����ϡ�����飬����ԭʼ����ת��Ϊϡ������
		// 1���ҵ�ԭʼ���������У�����Ч��ֵ�ĸ�����Ϊϡ������ĵ�һ�С�
		// 2���ҵ���Ч��ֵ��λ�ü���ֵ������ϡ������ĺ��漸�С�

		// ����ԭʼ���飬sum��¼��Ч���ֵĸ���
		int sum = 0;
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < chessArr.length; j++) {
				if (chessArr[i][j] != 0)
					sum++;
			}
		}
		// ����ϡ������
		// ϡ�������һ��
		int sparseint[][] = new int[sum + 1][3];
		sparseint[0][0] = chessArr.length;
		sparseint[0][1] = chessArr.length;
		sparseint[0][2] = sum;
		// ϡ��������Ч��ֵλ����ֵ��
		int count = 0;// ���ڼ�¼�ǵڼ���������ֵ
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < chessArr.length; j++) {
				if (chessArr[i][j] != 0) {
					count++;
					sparseint[count][0] = i;
					sparseint[count][1] = j;
					sparseint[count][2] = chessArr[i][j];
				}
			}
		}

		// ���ϡ������
		System.out.println();
		System.out.println("���ϡ������");
		for (int i = 0; i < sparseint.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseint[i][0], sparseint[i][1], sparseint[i][2]);
		}

		// ��ϡ������ת��Ϊ��ͨ��ά����
		// ����ϡ�������һ����ԭʼ��������г�����Ϣ������ͨ��ά����
		int chess2[][] = new int[sparseint[0][0]][sparseint[0][1]];
		// ����ϡ�����齫���ݻָ�����ά����
		for (int i = 1; i < sparseint.length; i++) {
				chess2[sparseint[i][0]][sparseint[i][1]] = sparseint[i][2];
		}

		System.out.println("�����ά����");
		for (int i = 0; i < chess2.length; i++) {
			for (int j = 0; j < chess2.length; j++) {
				System.out.print(chess2[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
