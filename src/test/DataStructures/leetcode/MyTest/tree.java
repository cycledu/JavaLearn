package DataStructures.leetcode.MyTest;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/11/18/9:57
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class tree {
    static class Node {
        int no;
        Node left;
        Node right;

        public Node(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    '}';
        }
    }

    static Node root = null;
    static int[] arr = {10, 7, 11, 6, 8, 9};

    static {
        root = new Node(arr[0]);
        root.left = new Node(arr[1]);
        root.right = new Node(arr[2]);
        root.left.left = new Node(arr[3]);
        root.right.left = new Node(arr[4]);
        root.right.right = new Node(arr[5]);
    }

    static Stack<Node> stack = new Stack<Node>();
    static Stack<Node> stack2 = new Stack<Node>();

    @Test
    public void inOrder() {
        noCursionIn(root);
        noCursionPre(root);
        noCursionPost(root);
    }

    private void noCursionPost(Node root) {
        if (root == null)
            System.out.println("根节点为空");
        else {
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                stack2.push(root);
                if (root.left != null)
                    stack.push(root.left);
                if (root.right != null) {
                    stack.push(root.right);//后进stack，先弹，先进stack2
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop() + " ");
            }
        }
        System.out.println();
    }

    /**
     * 以非递归的方式前序遍历
     */
    private void noCursionPre(Node root) {
        if (root == null)
            System.out.println("根节点为空");
        else {
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root + " ");
                if (root.right != null)
                    stack.push(root.right);
                if (root.left != null)
                    stack.push(root.left);
            }
        }
        System.out.println();
    }

    /**
     * 以非递归的方式中序遍历
     */
    public void noCursionIn(Node root) {
        if (root == null)
            System.out.println("根节点为空");
        else {
            addLeft(root);
            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                System.out.print(pop + " ");
                if (pop.right != null)
                    addLeft(pop.right);
            }
        }
        System.out.println();
    }

    public void addLeft(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
