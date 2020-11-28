package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/05/29/22:01
 * @Description :输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @Page or WebSite：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @Expected result ：
 */
public class Test29 {
    /**
     * 1、先从0，0开始
     * 2、顺序：右→下→左→上→右
     * 3、创建相同结构的数组存放判断原数组中元素是否已经走过的boolean值
     * 纵轴若到右边界，向下走，同时横轴+1，向下走前判断下面的是否已经访问过
     * 纵轴若到左边界，向上走，同时横轴-1，向上走前判断上面的是否已经访问过
     * 横轴若到左边界，向右走，同时纵轴+1，向右走前判断右面的是否已经访问过
     * 横轴若到右边界，向左走，同时纵轴-1，向左走前判断左面的是否已经访问过
     * 4、走过的值依次放到一个新数组中
     */
    //太过繁琐
    public int[] spiralOrder(int[][] matrix) {
        int[] returnMatix = new int[matrix.length * matrix[0].length];
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int x = 0, y = 0, size = matrix.length * matrix[0].length, i = 0;
        while (x == 0 && y < matrix[0].length && flag[x][++y] == false) {
            returnMatix[i++] = matrix[x][y];
            flag[x][y] = true;
            size--;
            if (size == 0)
                return returnMatix;
        }
        return returnMatix;
    }

    public int[] spiralOrder1(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        //设定上右左下边界，x为自增的插值数组的下标
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        //创建插值数组
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            //第一行：从左向右边界前进取值
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }
    public static void main(String[] args) {
    }
}
