package DataStructures.leetcode.SwordToOffer.simple;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/05/28/23:19
 * @Description :
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @Page or WebSite：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @Expected result ：
 */
public class Test28 {

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(right.left, left.right);
    }

    //[1,2,2,2,null,2]无法通过
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;

        Test28 test28 = new Test28();
        System.out.println(test28.isSymmetric(treeNode1));
    }
}
