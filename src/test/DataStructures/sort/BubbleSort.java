package DataStructures.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5, -6, 4, 0, 8};
        boolean flag = false;//表示是否进行过排序交换,判断并跳出循环，避免无意义的比较
        int temp = 0;
        // 排序，每次将最大的数放到最后
        for (int j = 0; j < arr.length - 1; j++) {

            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    //如果当前的数比下一个数大，则交换
                    flag = true;
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
            if (!flag) {//在一趟排序中，一次交换都没有发生过（没有出现过一个数比下一个数大的情况）
                break;
            }
        }
        System.out.println("排序后");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
