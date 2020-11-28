package DataStructures.avlTree;

import org.junit.Test;

/**
 * @Author : jingtao
 * @Data : 2020/10/17/23:38
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class AVLTreeTest {
    @Test
    public void test() {
      /*  Node node8 = new Node(10,
                new Node(7, new Node(5, new Node(3, null, new Node(4)), new Node(6)),
                        new Node(8, null, new Node(11))),
                new Node(9));

        if (node8 == null) {
            System.out.println("空节点");
        }
        node8.preFor();
        System.out.println();
        //进行旋转
        Node node = rotateTree(node8);

        node.preFor();
        */

        Node node10 = new Node(10,
                new Node(7, new Node(6), new Node(8, null, new Node(9))),
                new Node(11));
        //向子节点递归进行旋转
        Node node = resursionRotate(node10);
        node.preFor();
    }

    private Node resursionRotate(Node node) {
        Node node1 = rotateTree(node, 1);
        return node1;
    }

    private Node rotateTree(Node node8, int lev) {
        int i = nodeHeight(node8.left) - nodeHeight(node8.right);
        Node newNode = null;
        while (i > lev || i < -lev) {
            //右旋
            if (i > lev) {
                //右旋前先对左子节点判断是否需要左旋
                if (node8.left != null) {
                    Node node = node8.left;
                    while (nodeHeight(node.left) < nodeHeight(node.right)) {
                        node = rotateTree(node8.left, 0);
                    }
                    node8.left = node;
                }
                newNode = rightRotate(node8);
                //左旋
            } else if (i < -lev) {
                if (node8.right != null) {
                    Node node = node8.left;
                    while (nodeHeight(node.right) > nodeHeight(node.left)) {
                        node = rotateTree(node8.right, 0);
                    }
                    node8.right = node;
                }
                newNode = leftRotate(node8);
            } else {
                return node8;
            }
            i = nodeHeight(newNode.left) - nodeHeight(newNode.right);
        }
        return newNode;
    }

    //求一个子树的最大高度
    public int nodeHeight(Node node) {
        if (node == null) return 1;
        else return Math.max(nodeHeight(node.left), nodeHeight(node.right)) + 1;
    }

    //左旋
    public Node leftRotate(Node node) {
        //创建与根节点同值的新节点，并将根节点的左节点设置为新节点的左节点
        Node newNode = new Node(node.value);
        newNode.left = node.left;
        //将根节点的右节点的左节点设置为新节点的右节点
        newNode.right = node.right.left;
        //将新节点设置为原根节点右节点的左节点
        node.right.left = newNode;
        return node.right;
    }

    //右旋
    public Node rightRotate(Node node) {
        //创建与根节点同值的新节点，并将根节点的右节点设置为新节点的右节点
        Node newNode = new Node(node.value);
        newNode.right = node.right;
        //将根节点的左节点的右节点设置为新节点的左节点
        newNode.left = node.left.right;
        //将新节点设置为原根节点左节点的右节点
        node.left.right = newNode;
        return node.left;
    }


    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void preFor() {
            System.out.print(value + "-");
            if (left != null) left.preFor();
            if (right != null) right.preFor();
        }
    }
}
