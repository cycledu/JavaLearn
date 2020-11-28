package DataStructures.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void shellSort(int[] arr) {

		int temp = 0;
		int count = 0;
		// 根据前面的逐步分析，使用循环处理
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
				// for (int j = i - gap; j >= 0; j -= gap) {
				// // 如果当前元素大于加上步长后的那个元素，说明交换
				// if (arr[j] > arr[j + gap]) {
				// temp = arr[j];
				// arr[j] = arr[j + gap];
				// arr[j + gap] = temp;
				// }
				// }
				for (int j = 0; j < arr.length-gap; j ++) {
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
		}
	}

	// 对交换式的希尔排序进行优化->移位法
	public static void shellSort2(int[] arr) {

		// 增量gap, 并逐步的缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;//i的值赋给j以免再数值向前移动比较时影响i的值，导致循环受到影响
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						// 移动
						arr[j] = arr[j - gap];
						j -= gap;
					}
					// 当退出while后，就给temp找到插入的位置
					arr[j] = temp;
				}

			}
		}
	}
}