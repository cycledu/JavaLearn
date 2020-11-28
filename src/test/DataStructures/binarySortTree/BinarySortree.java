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

// ��������������
class BinarySortTree {
    private Node root;

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

    // �ҵ����
    public Node searchNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    // �ҵ�Ҫɾ�����ĸ����
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    // �ҵ���ɾ�������Ϊ�������ӽ������ֵ���(����ѭ�����Ҳ���),��ɾ���ҵ��Ľ��()
    public int findleftMax(Node node) {
        Node targetleftNode = node.left;

        while (targetleftNode.right != null) {
            targetleftNode = targetleftNode.right;
        }
        int a = targetleftNode.value;
        delNode(targetleftNode.value);
        return a;
    }

    // ɾ�����ķ���

    /**
     * �������
     * ��ɾ���Ľ����һ��Ҷ�ӽ�㣺ֱ�ӽ��ҵ��Ľ��ɾ������
     * ��ɾ���Ľ����һ�����ӽ�����һ�����ӽ�㣬
     * ��Ҫɾ���Ľ����ӽ�㸳�����ĸ���㼴�ɣ���ʱ���Ͳ�����֮��
     * ��Ҫɾ���Ľ�������ӽ�㶼���ڣ�
     * ���Խ�����Ϊ�����������������е����ֵ�����Լ�����������������Сֵ�����Լ�
     *
     * @param value Ҫɾ����ֵ
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            // 1.���ҵ�Ҫɾ���Ľ��
            Node targetNode = searchNode(value);
            if (targetNode == null) {
                return;
            }
            // ������Ƿ��ֵ�ǰ��Ŷ���������ֻ��һ�����
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            // 2.�ҵ�Ҫɾ�����ĸ���㣨������ڣ�
            Node parent = searchParent(value);
            //���ж��Ƿ�Ϊ���ڵ����Ǹ��ڵ㣬ֱ�ӽ����������ֵ����������Сֵ��������Ȼ��ɾ���ҵ��Ľڵ㲢����
            //���ڵ����������ڵ�Ϊ�գ�
            if (parent == null) {
                int findleftMax = findleftMax(targetNode);
                targetNode.value = findleftMax;
                return;
            }
            // 3.����ɾ������ж�
            // ���ɾ���Ľ����Ҷ�ӽ��
            if (targetNode.left == null && targetNode.right == null) {
                // �ж����丸�������ӽ�㻹�����ӽ��
                // ֱ�ӽ��丸���������ÿ�
                if (parent.left == targetNode) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                //�ý����������һ�����
            } else if ((targetNode.left != null && targetNode.right == null)
                    || (targetNode.right != null && targetNode.left == null)) { // ���ɾ�����Ƿ�Ҷ�ӽ�㣬������ֻ�������һ���ӽ��
                //��һ����ڵ�
                if (targetNode.left != null && targetNode.right == null) {
//                    if (parent == null) {
//                        root = targetNode.left;
//                    } else {
                    // �ж�Ҫɾ����������ӽ�㻹�����ӽ��
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
            } else { // Ҫɾ���Ľ�����ҽ�㶼����
                // �ҵ�Ҫɾ�������Ϊ�������������������ֵ����������������Сֵ��㣬���滻Ҫɾ���Ľ��ֵ��ɾ�������ҵ��Ľ��ֵ
                int findleftMax = findleftMax(targetNode);
                targetNode.value = findleftMax;
            }

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
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    // �ҵ�Ҫɾ���Ľ��
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

    //�����ĸ��ڵ����±������ҵ�һ�����ҽڵ�Ϊ��ֵ�Ľ��
    // �ҵ�Ҫɾ�����ĸ���㣬��Ϊ��ɾ����Ҷ�ӽ��ʱҪ������Ϊ������ĳ���ӽ���ֵ���ǵ�����,��ɾ�����ҵ���ĳ���ӽ��
    public Node searchParent(int value) {
        // �����ǰ������Ҫɾ�����ĸ���㣬�ͷ���
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // ���Ҫ���ҵ�ֵС�ڵ�ǰ����ֵ�����ҵ�ǰ�������ӽ�㲻Ϊ��
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value > this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
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
}
