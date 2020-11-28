package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/11/05/20:41
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class Test55_2 {
    public static void main(String[] args) {


    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return false;
        return Math.abs(height(root.left, 0) - height(root.right, 0)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node, int i) {
        if (node == null) {
            return i;
        } else {
            i++;
            return Math.max(height(node.left, i), height(node.right, i));
        }
    }

}
