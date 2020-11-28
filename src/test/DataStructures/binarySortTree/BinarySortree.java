package DataStructures.binarySortTree;

public class BinarySortree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
		/*binarySortTree.delNode(2);
		binarySortTree.delNode(5);
		binarySortTree.delNode(9);
		binarySortTree.delNode(3);
		binarySortTree.delNode(7);
		binarySortTree.delNode(12);
		binarySortTree.delNode(1);*/
        binarySortTree.delNode(7);
        binarySortTree.infixOrder();
    }
}

// 创建二叉排序树
class BinarySortTree {
    private Node root;

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

    // 找到结点
    public Node searchNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    // 找到要删除结点的父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    // 找到以删除结点作为根的左子结点的最大值结点(子树循环向右查找),并删除找到的结点()
    public int findleftMax(Node node) {
        Node targetleftNode = node.left;

        while (targetleftNode.right != null) {
            targetleftNode = targetleftNode.right;
        }
        int a = targetleftNode.value;
        delNode(targetleftNode.value);
        return a;
    }

    // 删除结点的方法

    /**
     * 三种情况
     * ①删除的结点是一个叶子结点：直接将找到的结点删除即可
     * ②删除的结点有一个左子结点或有一个右子结点，
     * 将要删除的结点的子结点赋给它的父结点即可，此时结点就不在树之中
     * ③要删除的结点左右子结点都存在，
     * 可以将其作为根结点的树的左子树中的最大值赋给自己，或将其右子树的最小值赋给自己
     *
     * @param value 要删除的值
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            // 1.先找到要删除的结点
            Node targetNode = searchNode(value);
            if (targetNode == null) {
                return;
            }
            // 如果我们发现当前这颗二叉排序树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            // 2.找到要删除结点的父结点（如果存在）
            Node parent = searchParent(value);
            //先判断是否为根节点若是根节点，直接将左子树最大值或右子树最小值赋给它，然后删除找到的节点并返回
            //根节点特征（父节点为空）
            if (parent == null) {
                int findleftMax = findleftMax(targetNode);
                targetNode.value = findleftMax;
                return;
            }
            // 3.三种删除情况判断
            // 如果删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                // 判断是其父结点的左子结点还是右子结点
                // 直接将其父结点的子树置空
                if (parent.left == targetNode) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                //该结点存在左或右一个结点
            } else if ((targetNode.left != null && targetNode.right == null)
                    || (targetNode.right != null && targetNode.left == null)) { // 如果删除的是非叶子结点，并且其只有左或右一个子结点
                //有一个左节点
                if (targetNode.left != null && targetNode.right == null) {
//                    if (parent == null) {
//                        root = targetNode.left;
//                    } else {
                    // 判断要删除结点是左子结点还是右子结点
                    if (parent.left == targetNode) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
//                    }
                } else {
//                    if (parent == null) {
//                        root = targetNode.right;
//                    } else {
                    if (parent.left == targetNode) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
//                    }
                }
            } else { // 要删除的结点左右结点都存在
                // 找到要删除结点作为根的树的左子树的最大值结点或其右子树的最小值结点，并替换要删除的结点值并删除掉新找到的结点值
                int findleftMax = findleftMax(targetNode);
                targetNode.value = findleftMax;
            }

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
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    // 找到要删除的结点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (this.value < value) {
            if (this.right == null)
                return null;
            return this.right.search(value);
        } else {
            if (this.value > value) {
                if (this.left == null)
                    return null;
                return this.left.search(value);
            }
        }
        return null;
    }

    //从树的根节点向下遍历，找到一个左右节点为该值的结点
    // 找到要删除结点的父结点，因为在删除非叶子结点时要将其作为根结点的某个子结点的值覆盖到自身,并删除掉找到的某个子结点
    public Node searchParent(int value) {
        // 如果当前结点就是要删除结点的父结点，就返回
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果要查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value > this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
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
}
