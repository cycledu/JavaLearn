package DataStructures.avlTree;

import java.util.Stack;

public class CreatAVLTree {
    public static void main(String[] args) {
        // int[] arr = { 4, 3, 6, 5, 7, 8 };
        // ��Ҫ˫��ת����Ϊ�����ɵĶ��������������н�㶼���ӽ���ʱ��ʼ��ת��
        // ��Ϊ�������������-���������>1,��Ҫ����ת���������ĸ��������ӽ������������������
        // ���Ե�������һ����ת��������һ��ƽ�����������Ҫ�������������ӽ�����һ������ת
        int[] arr = {10, 7, 11, 6, 8, 9}
//				{ 10, 11, 7, 6, 8, 9 }
                ;
        AVLTree avlTree = new AVLTree();
        // ��ӽ��
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        // ����
        System.out.println("�������");
        avlTree.infixOrder();
        System.out.println("���������ȣ�" + avlTree.getRoot().height());
        System.out.println("�����������߶�=" + avlTree.getRoot().leftheight());
        System.out.println("�����������߶�=" + avlTree.getRoot().rightheight());
        System.out.println("��ǰ�ĸ����=" + avlTree.getRoot());

        avlTree.inOrder();
    }
}

// ��������������
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

    // �������
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("���Ϊ�գ��޷������������");
        }
    }

    //����������ǵݹ飩
    public void inOrder() {
        if (root != null) {
            root.inOrder();
        } else {
            System.out.println("���Ϊ�գ��޷������������");
        }
    }
}

// ���
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // ��ӽ��ķ���
    // �Եݹ�ķ�ʽ��ע����Ҫ���������������Ҫ��
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // �жϴ���Ľ���ֵ���͵�ǰ�����ĸ�����ֵ�Ĺ�ϵ
        if (node.value < this.value) {
            // �����ǰ������ӽ��Ϊnull
            if (this.left == null) {
                this.left = node;
            } else {
                // �ݹ������������
                this.left.add(node);
            }
        } else {
            // �����ǰ������ӽ��Ϊnull
            if (this.right == null) {
                this.right = node;
            } else {
                // �ݹ������������
                this.right.add(node);
            }
        }

        // ������������-��������ȴ���1����������ת
        if (leftheight() - rightheight() > 1) {
            if (this.left.leftheight() < this.left.rightheight()) {
                this.left.leftRotate();
            }
            rightRotate();
            return;
        }
        // ������������-��������ȴ���1����������ת
        if (rightheight() - leftheight() > 1) {
            if (this.right.leftheight() > this.right.rightheight()) {
                this.right.rightRotate();
            }
            leftRotate();
        }

    }

    // ����ת
    public void leftRotate() {
        Node newNode = new Node(this.value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.value = right.value;
        this.right = right.right;
        this.left = newNode;
    }

    // ����ת
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

    // ��������������
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // �������������ʱ�ж�������������Ȳ��Ƿ����1�������Ƿ����������ת
    // ���������������
    public int rightheight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    // ���������������
    public int leftheight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    // �������
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.print("����");
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