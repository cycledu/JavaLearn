package DataStructures.avlTree;

import java.util.Stack;

public class CreatAVLTree {
    public static void main(String[] args) {
        // int[] arr = { 4, 3, 6, 5, 7, 8 };
        // 需要双旋转，因为它生成的二叉排序树在所有结点都连接结束时开始旋转，
        // 因为它的左子树深度-右子树深度>1,需要右旋转，但是它的根结点的左子结点的右子树比左子树深，
        // 所以单纯进行一次旋转不能生成一个平衡二叉树，先要对它根结点的左子结点进行一次左旋转
        int[] arr = {10, 7, 11, 6, 8, 9}
//				{ 10, 11, 7, 6, 8, 9 }
                ;
        AVLTree avlTree = new AVLTree();
        // 添加结点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        // 遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();
        System.out.println("树的最大深度：" + avlTree.getRoot().height());
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftheight());
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightheight());
        System.out.println("当前的根结点=" + avlTree.getRoot());

        avlTree.inOrder();
    }
}

// 创建二叉排序树
class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("结点为空，无法进行中序遍历");
        }
    }

    //中序遍历（非递归）
    public void inOrder() {
        if (root != null) {
            root.inOrder();
        } else {
            System.out.println("结点为空，无法进行中序遍历");
        }
    }
}

// 结点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // 添加结点的方法
    // 以递归的方式，注意需要满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判断传入的结点的值，和当前子树的根结点的值的关系
        if (node.value < this.value) {
            // 如果当前结点左子结点为null
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归向左子树添加
                this.left.add(node);
            }
        } else {
            // 如果当前结点右子结点为null
            if (this.right == null) {
                this.right = node;
            } else {
                // 递归向左子树添加
                this.right.add(node);
            }
        }

        // 如果左子树深度-右子树深度大于1，进行右旋转
        if (leftheight() - rightheight() > 1) {
            if (this.left.leftheight() < this.left.rightheight()) {
                this.left.leftRotate();
            }
            rightRotate();
            return;
        }
        // 如果右子树深度-左子树深度大于1，进行左旋转
        if (rightheight() - leftheight() > 1) {
            if (this.right.leftheight() > this.right.rightheight()) {
                this.right.rightRotate();
            }
            leftRotate();
        }

    }

    // 左旋转
    public void leftRotate() {
        Node newNode = new Node(this.value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.value = right.value;
        this.right = right.right;
        this.left = newNode;
    }

    // 右旋转
    public void rightRotate() {
        Node newNode = new Node(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = left.value;
        this.left = left.left;
        this.right = newNode;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    // 返回树的最大深度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // 用于在新增结点时判断左右子树的深度差是否大于1来决定是否进行左右旋转
    // 返回右子树的深度
    public int rightheight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    // 返回左子树的深度
    public int leftheight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.print("中序：");
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void inOrder() {
        Node p = this;
        leftResucin(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            System.out.println(p);
            leftResucin(p.right);
        }
    }

    public void leftResucin(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    static Stack<Node> stack = new Stack();
}