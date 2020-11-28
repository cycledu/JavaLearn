package DataStructures.sparsearray;

public class SparseArray {
	public static void main(String[] args) {
		// 创建原始数组，并为其赋有效值
		// 1表示白子，2表示黑子
		int chessArr[][] = new int[8][8];
		chessArr[2][3] = 1;
		chessArr[3][6] = 2;
		System.out.println("原始数组：");
		for (int[] c : chessArr) {
			for (int d : c) {
				System.out.printf("%d\t", d);
			}
			System.out.println();
		}

		// 创建稀疏数组，并将原始数组转换为稀疏数组
		// 1、找到原始数组中行列，及有效数值的个数，为稀疏数组的第一行。
		// 2、找到有效数值的位置及数值，放在稀疏数组的后面几行。

		// 遍历原始数组，sum记录有效数字的个数
		int sum = 0;
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < chessArr.length; j++) {
				if (chessArr[i][j] != 0)
					sum++;
			}
		}
		// 创建稀疏数组
		// 稀疏数组第一行
		int sparseint[][] = new int[sum + 1][3];
		sparseint[0][0] = chessArr.length;
		sparseint[0][1] = chessArr.length;
		sparseint[0][2] = sum;
		// 稀疏数组有效数值位置数值行
		int count = 0;// 用于记录是第几个非零数值
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

		// 输出稀疏数组
		System.out.println();
		System.out.println("输出稀疏数组");
		for (int i = 0; i < sparseint.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseint[i][0], sparseint[i][1], sparseint[i][2]);
		}

		// 将稀疏数组转换为普通二维数组
		// 根据稀疏数组第一行中原始数组的行列长度信息创建普通二维数组
		int chess2[][] = new int[sparseint[0][0]][sparseint[0][1]];
		// 遍历稀疏数组将数据恢复到二维数组
		for (int i = 1; i < sparseint.length; i++) {
				chess2[sparseint[i][0]][sparseint[i][1]] = sparseint[i][2];
		}

		System.out.println("输出二维数组");
		for (int i = 0; i < chess2.length; i++) {
			for (int j = 0; j < chess2.length; j++) {
				System.out.print(chess2[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
