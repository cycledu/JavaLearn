package DataStructures.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/10/18/10:16
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public class heapSort {

    @Test
    public void sort() {
        int[] tree = {2, 6, 7, 9, 10, 15, 16, 21};
        //�õ����һ����Ҷ�ӽڵ�
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
        //�����ķ�Ҷ�ӽڵ�Ӻ���ǰ��������ÿһ����Ҷ�ӽڵ�����������ֵ���ҳ������滻
        while (last >= 0) {
            int topIndex = last;
            //�ж����һ����Ҷ�ӽڵ�������ӽڵ��Ƿ��б��Լ���ģ������滻
            //��Ϊһ����ȫ����������Ҷ�ӽڵ�϶��������ӽڵ�
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
