package DataStructures.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-5, 5, 9, 18, 0};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {
        // 选择排序，每次循环检索最小的值和开始进行循环的元素交换
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 发现更小值，进行交换
                if (arr[j] < min) {
                    min = arr[j];
                    minindex = j;
                }
            }
            // 内层for循环结束，全数组最小值找到min
            // 判断是否需要交换
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