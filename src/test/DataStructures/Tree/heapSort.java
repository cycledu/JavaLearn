package DataStructures.Tree;

import java.util.Arrays;

public class heapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapsort(arr);
        String string = "尚硅谷Java设计模式，韩顺平图解java设计模式 - 85.";
        System.out.println(string.length());
    }

    // 堆排序方法
    public static void heapsort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序!!");

        //从最后一个非叶子结点开始，往前开始构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("数组=" + Arrays.toString(arr));
    }

    /**
     * 将树构建成大顶堆的方法
     *
     * @param arr    待调整的数组
     * @param i      开始调整的数组对应二叉树中非叶子结点的元素位置
     * @param length 数组中需要调整的元素个数， 因为每一次调用调整方法之后排序方法会将最大的值数组放到数组最后， 需要排序的元素个数会依次减少
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        // 定义临时变量存放非叶子结点的值
        int temp = arr[i];
        // 遍历i下（数组之后即i位置的节点的树的下端子树）的数找出其子树中比i位置的值大的数并进行交换
        // j*2+1表示进入数组对应二叉树的子结点进行比较,因为j结点的子结点的位置总是j*2+1
        for (int j = i * 2 + 1; j < arr.length; j = j * 2 + 1) {
            // i的左子结点的值是否大于右子结点的值
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;// j指向右子结点
            }
            // 将子结点中最大的值和父结点i位置的值进行比较
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j; // !!! i 指向 j,继续循环比较（进行以子结点为父的子树的大顶堆比较赋值）
            } else {
                break;
            }
        }
        // 当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        arr[i] = temp;// 将temp值放到调整后的位置
    }
}
