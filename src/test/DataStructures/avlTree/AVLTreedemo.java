package DataStructures.avlTree;

public class AVLTreedemo {

    public static void main(String[] args) {
        // int[] arr = {4,3,6,5,7,8};
        // int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = {10, 11, 7, 6, 8, 9};
        // ����һ�� avltree1����
        avltree1 avltree1 = new avltree1();
        // ��ӽ��
        for (int i = 0; i < arr.length; i++) {
            avltree1.add(new node1(arr[i]));
        }

        // ����
        System.out.println("�������");
        avltree1.infixOrder();

        System.out.println("��ƽ�⴦��~~");
        System.out.println("���ĸ߶�=" + avltree1.getRoot().height()); // 3
        System.out.println("�����������߶�=" + avltree1.getRoot().leftHeight()); // 2
        System.out.println("�����������߶�=" + avltree1.getRoot().rightHeight()); // 2
        System.out.println("��ǰ�ĸ����=" + avltree1.getRoot());// 8

    }

}

// ����avltree1
class avltree1 {
    private node1 root;

    public node1 getRoot() {
        return root;
    }

    // ����Ҫɾ���Ľ��
    public node1 search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    // ���Ҹ����
    public node1 searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    // ��д����:
    // 1. ���ص� ��node1 Ϊ�����Ķ�������������С����ֵ
    // 2. ɾ��node1 Ϊ�����Ķ�������������С���

    /**
     * @param node1 ����Ľ��(���������������ĸ����)
     * @return ���ص� ��node1 Ϊ�����Ķ�������������С����ֵ
     */
    public int delRightTreeMin(node1 node1) {
        node1 target = node1;
        // ѭ���Ĳ������ӽڵ㣬�ͻ��ҵ���Сֵ
        while (target.left != null) {
            target = target.left;
        }
        // ��ʱ target��ָ������С���
        // ɾ����С���
        delnode1(target.value);
        return target.value;
    }

    // ɾ�����
    public void delnode1(int value) {
        if (root == null) {
            return;
        } else {
            // 1.������ȥ�ҵ�Ҫɾ���Ľ�� targetnode1
            node1 targetnode1 = search(value);
            // ���û���ҵ�Ҫɾ���Ľ��
            if (targetnode1 == null) {
                return;
            }
            // ������Ƿ��ֵ�ǰ��Ŷ���������ֻ��һ�����
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            // ȥ�ҵ�targetnode1�ĸ����
            node1 parent = searchParent(value);
            // ���Ҫɾ���Ľ����Ҷ�ӽ��
            if (targetnode1.left == null && targetnode1.right == null) {
                // �ж�targetnode1 �Ǹ��������ӽ�㣬�������ӽ��
                if (parent.left != null && parent.left.value == value) { // �����ӽ��
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {// �����ӽ��
                    parent.right = null;
                }
            } else if (targetnode1.left != null && targetnode1.right != null) { // ɾ�������������Ľڵ�
                int minVal = delRightTreeMin(targetnode1.right);
                targetnode1.value = minVal;

            } else { // ɾ��ֻ��һ�������Ľ��
                // ���Ҫɾ���Ľ�������ӽ��
                if (targetnode1.left != null) {
                    if (parent != null) {
                        // ��� targetnode1 �� parent �����ӽ��
                        if (parent.left.value == value) {
                            parent.left = targetnode1.left;
                        } else { // targetnode1 �� parent �����ӽ��
                            parent.right = targetnode1.left;
                        }
                    } else {
                        root = targetnode1.left;
                    }
                } else { // ���Ҫɾ���Ľ�������ӽ��
                    if (parent != null) {
                        // ��� targetnode1 �� parent �����ӽ��
                        if (parent.left.value == value) {
                            parent.left = targetnode1.right;
                        } else { // ��� targetnode1 �� parent �����ӽ��
                            parent.right = targetnode1.right;
                        }
                    } else {
                        root = targetnode1.right;
                    }
                }

            }

        }
    }

    // ��ӽ��ķ���
    public void add(node1 node1) {
        if (root == null) {
            root = node1;// ���rootΪ����ֱ����rootָ��node1
        } else {
            root.add(node1);
        }
    }

    // �������
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("����������Ϊ�գ����ܱ���");
        }
    }
}

// ����node1���
class node1 {
    int value;
    node1 left;
    node1 right;

    public node1(int value) {

        this.value = value;
    }

    // �����������ĸ߶�
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    // �����������ĸ߶�
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    // ���� �Ըý��Ϊ���������ĸ߶�
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // ����ת����
    private void leftRotate() {

        // �����µĽ�㣬�Ե�ǰ������ֵ
        node1 newnode1 = new node1(value);
        // ���µĽ������������óɵ�ǰ����������
        newnode1.left = left;
        // ���µĽ������������óɴ����ȥ������������������
        newnode1.right = right.left;
        // �ѵ�ǰ����ֵ�滻�����ӽ���ֵ
        value = right.value;
        // �ѵ�ǰ�������������óɵ�ǰ�����������������
        right = right.right;
        // �ѵ�ǰ����������(���ӽ��)���ó��µĽ��
        left = newnode1;

    }

    // ����ת
    private void rightRotate() {
        node1 newnode1 = new node1(value);
        newnode1.right = right;
        newnode1.left = left.right;
        value = left.value;
        left = left.left;
        right = newnode1;
    }

    // ����Ҫɾ���Ľ��

    /**
     * @param value ϣ��ɾ���Ľ���ֵ
     * @return ����ҵ����ظý�㣬���򷵻�null
     */
    public node1 search(int value) {
        if (value == this.value) { // �ҵ����Ǹý��
            return this;
        } else if (value < this.value) {// ������ҵ�ֵС�ڵ�ǰ��㣬���������ݹ����
            // ������ӽ��Ϊ��
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else { // ������ҵ�ֵ��С�ڵ�ǰ��㣬���������ݹ����
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }

    }

    // ����Ҫɾ�����ĸ����

    /**
     * @param value Ҫ�ҵ��Ľ���ֵ
     * @return ���ص���Ҫɾ���Ľ��ĸ���㣬���û�оͷ���null
     */
    public node1 searchParent(int value) {
        // �����ǰ������Ҫɾ���Ľ��ĸ���㣬�ͷ���
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // ������ҵ�ֵС�ڵ�ǰ����ֵ, ���ҵ�ǰ�������ӽ�㲻Ϊ��
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value); // ���������ݹ����
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value); // ���������ݹ����
            } else {
                return null; // û���ҵ������
            }
        }

    }

    @Override
    public String toString() {
        return "node1 [value=" + value + "]";
    }

    // ��ӽ��ķ���
    // �ݹ����ʽ��ӽ�㣬ע����Ҫ���������������Ҫ��
    public void add(node1 node1) {
        if (node1 == null) {
            return;
        }

        // �жϴ���Ľ���ֵ���͵�ǰ�����ĸ�����ֵ��ϵ
        if (node1.value < this.value) {
            // �����ǰ������ӽ��Ϊnull
            if (this.left == null) {
                this.left = node1;
            } else {
                // �ݹ�������������
                this.left.add(node1);
            }
        } else { // ��ӵĽ���ֵ���� ��ǰ����ֵ
            if (this.right == null) {
                this.right = node1;
            } else {
                // �ݹ�������������
                this.right.add(node1);
            }

        }

        // �������һ���������: (�������ĸ߶�-�������ĸ߶�) > 1 , ����ת
        if (rightHeight() - leftHeight() > 1) {
            // ����������������������ĸ߶ȴ����������������������ĸ߶�
            if (right != null && right.leftHeight() > right.rightHeight()) {
                // �ȶ����ӽ���������ת
                right.rightRotate();
                // Ȼ���ڶԵ�ǰ����������ת
                leftRotate(); // ����ת..
            } else {
                // ֱ�ӽ�������ת����
                leftRotate();
            }
            return; // ����Ҫ!!!
        }

        // �������һ��������� (�������ĸ߶� - �������ĸ߶�) > 1, ����ת
        if (leftHeight() - rightHeight() > 1) {
            // ����������������������߶ȴ��������������ĸ߶�
            if (left != null && left.rightHeight() > left.leftHeight()) {
                // �ȶԵ�ǰ��������(������)->����ת
                left.leftRotate();
                // �ٶԵ�ǰ����������ת
                rightRotate();
            } else {
                // ֱ�ӽ�������ת����
                rightRotate();
            }
        }
    }

    // �������
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

}
