package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/05/20/21:45
 * @Description :
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * @Page or WebSite：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @Expected result ：
 */
public class Test04 {
    public static void main(String[] args) {

    }
    /*
    从右上开始向左向下查找
    若比这个数小，则向左走，若相等就返回，若比这个数大，就向下走
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0] || target > matrix[matrix.length][matrix[0].length])
            return false;
        else {
            int rows = matrix.length, columns = matrix[0].length;
            int row = 0, column = columns - 1;
            while (row < rows && column >= 0) {
                int num = matrix[row][column];
                if (num == target)
                    return true;
                else if (num < target)
                    row++;
                else
                    column--;
            }
        }
        return false;
    }
}
