package DataStructures.leetcode.SwordToOffer.simple;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/11/05/22:26
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class Test68_2 {
    static Stack<TreeNode> stack = new Stack();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }

    //深度优先遍历将节点的父亲都压入栈，对两个栈求交，获取栈顶元素
    public void searchNode(TreeNode root, TreeNode find) {
        stack.push(root);
        if (root.left!=null){
        }

    }
}
