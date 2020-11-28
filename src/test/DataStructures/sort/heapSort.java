package DataStructures.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/10/18/10:16
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class heapSort {

    @Test
    public void sort() {
        int[] tree = {2, 6, 7, 9, 10, 15, 16, 21};
        //得到最后一个非叶子节点
        int size = tree.length;
        int last;
        while (size > 0) {
            last = size / 2 - 1;
            heapsort(last, tree, size);
            Swap(0, size - 1, tree);
            size--;
        }
        for (int i = tree.length - 1; i >= 0; i--) {
            System.out.print(tree[i] + " ");
        }
    }

    private void heapsort(int last, int[] tree, int size) {
        //操作的非叶子节点从后向前缩减，将每一个非叶子节点的子树中最大值都找出来并替换
        while (last >= 0) {
            int topIndex = last;
            //判断最后一个非叶子节点的左右子节点是否有比自己大的，若有替换
            //作为一个完全二叉树，非叶子节点肯定存在左子节点
            if (tree[last] < tree[last * 2 + 1])
                topIndex = last * 2 + 1;
            if (last * 2 + 2 < size && tree[topIndex] < tree[last * 2 + 2])
                topIndex = last * 2 + 2;
            Swap(topIndex, last, tree);
            last--;
        }
    }

    private void Swap(int topIndex, int last, int[] tree) {
        int temp = tree[last];
        tree[last] = tree[topIndex];
        tree[topIndex] = temp;
    }
}
