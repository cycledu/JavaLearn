package DataStructures.leetcode.SwordToOffer.simple;

import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/05/28/22:54
 * @Description :请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @Page or WebSite：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @Expected result ：
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
public class Test27 {
    //递归
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode temp = null;
        if (root == null) return null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    //利用栈的先进后出配合循环实现二叉树的镜像转换
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            //4弹出，压入2，7并交换，此时2，7依然在栈中
            //7弹出，将7的子结点6，9入并交换，此时栈中有2，6，9
            //9弹出，左右子节点为空，无变化
            //6弹出，左右子节点为空，无变化
            //2弹出，左右子节点1，3压入栈中并交换
            //3，1一次弹出左右子节点为空，无变化
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }


}
