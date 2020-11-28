package DataStructures.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int arr[] = { 53, 3, 542, 748, 14, 214 };
		radixsort(arr);
	}

	public static void radixsort(int arr[]) {

		// 获取原数组中最大的数值位数
		int figure = (arr[0] + "").length();
		for (int i = 1; i < arr.length; i++) {
			if (figure < (arr[i] + "").length())
				figure = (arr[i] + "").length();
		}
		// 创建一个二维数组作为桶用来存放取出的数值(可能会平均放几列,每一位数可能时0-9所以10列，也可能同时都放在一列)
		int bucket[][] = new int[10][arr.length];
		// 创建一维数组记录每一次分桶后，每一个桶中有几个数值
		// 比如：recode[0] , 记录的就是 第0桶的放入数据个数位recode[0]个
		int[]recode = new int[10];
		// 按照从个位到十位的顺序依次循环将数值放在桶中再取出
		for (int i = 0, n = 1; i < figure; i++, n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				// 循环将每个数通过其某一个位数的位置上数值放在对应的桶中
				// 取出每个元素对应位的值
				int digitOfElement = arr[j] / n % 10;
				// 放进对应的桶中
				bucket[digitOfElement][recode[digitOfElement]] = arr[j];
				recode[digitOfElement]++;
			}
			// 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
			int index = 0;
			// 遍历每一桶，并将桶中是数据，放入到原数组
			for (int k = 0; k < recode.length; k++) {
				if (recode[k] != 0) { // 说明第k个位置的桶中有 recode[k]个数
					for (int j = 0; j < recode[k]; j++) {
						arr[index++] = bucket[k][j];
					}
				}
				// 根据一维记录数组的每个值取出桶中的数后，将recode清零，以免下一次根据旧的记录数取到不存在值的位置，发生空指针异常
				recode[k] = 0;
			}
			System.out.println("第" + i + "轮，对个位的排序处理 arr =" + Arrays.toString(arr));
		}
	}
}
