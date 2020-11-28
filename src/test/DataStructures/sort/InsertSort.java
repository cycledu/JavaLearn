package DataStructures.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-5, 5, 9, 18, 0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];//将当前要往有序列表中插入的值放入临时变量
            int insertIndex = i - 1;//表示有序列表最后的元素下标，同时也是无序数值开始向前进行比较的起始下标

            //如果索引值不小于0且无序数值比索引处的值小时，insertIndex减1继续比较,
            //直到找到某一个索引处的值小于循环比较的temp或索引已经为0，就说明temp的值找到合适的插入为值
            while (insertIndex >= 0 && temp < arr[insertIndex]) {
                //若有序数组中insertIndex处值比temp大，则将tmep位置的值覆盖为insertIndex位置的值（相当于有序数组的比当前元素较大就向后移动一个位置）
                arr[insertIndex + 1] = arr[insertIndex];//insertIndex+1就是这一次循环中i的值，但是不能直接使用i，做自减会影响遍历
                insertIndex--;
            }
            //此时，将temp赋给插入的位置（退出while时，temp就找到了要插入的位置）
            arr[insertIndex + 1] = temp;
        }
    }
}
