package DataStructures.leetcode.SwordToOffer.simple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/06/24/23:13
 * @Description :输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test55_1 {
    //后序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return resuion(root, 0);
    }

    public int resuion(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        } else {
            depth++;
            return Math.max(resuion(node.left, depth), resuion(node.right, depth));
        }
    }

    //层序遍历
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }}, tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
