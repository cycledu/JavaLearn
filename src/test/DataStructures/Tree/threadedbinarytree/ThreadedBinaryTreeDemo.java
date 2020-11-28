package DataStructures.Tree.threadedbinarytree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        // ����һ�����������������Ĺ���
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        // ����������������Ҫ�ݹ鴴��, ���ڼ򵥴���ʹ���ֶ�����
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        // ��������������
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
//		threadedBinaryTree.infixthreadedNodes();

        //ǰ��������
        threadedBinaryTree.prethreadedNode(root);
        // ����: ��10�Žڵ����
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("6�Ž���ǰ������� =" + leftNode); // 1
        System.out.println("6�Ž��ĺ�̽����=" + rightNode); // 6
        // ��������������������ʹ��ԭ���ı�������
        // threadedBinaryTree.infixOrder();
        System.out.println("ʹ���������ķ�ʽ���� ������������");
        threadedBinaryTree.infixthreadedList(); // 8, 3, 10, 1, 14, 6
    }
}

// ����ThreadedBinaryTree ʵ�������������ܵĶ�����
class ThreadedBinaryTree {
    private HeroNode root;
    // Ϊ��ʵ������������Ҫ����Ҫ��ָ��ǰ����ǰ������ָ��
    // �ڵݹ����������ʱ��pre ���Ǳ���ǰһ�����
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // ����һ��threadedNodes����
    public void infixthreadedNodes() {
        this.infixthreadedNodes(root);
    }

    // �����������������ķ���
    public void infixthreadedList() {
        // ����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
        HeroNode node = root;
        while (node != null) {
            // ѭ�����ҵ�leftType == 1�Ľ�㣬��һ���ҵ�����8���
            // �������ű������仯,��Ϊ��leftType==1ʱ��˵���ý���ǰ���������
            // ��������Ч���
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            // ��ӡ��ǰ������
            System.out.println(node);
            // �����ǰ������ָ��ָ����Ǻ�̽��,��һֱ���
            while (node.getRightType() == 1) {
                // ��ȡ����ǰ���ĺ�̽��
                node = node.getRight();
                System.out.println(node);
            }
            // �滻��������Ľ��
            node = node.getRight();

        }
    }

    // ��д�Զ��������������������ķ���

    /**
     * @param node ���ǵ�ǰ��Ҫ�������Ľ��
     */
    public void infixthreadedNodes(HeroNode node) {

        // ���node==null, ����������
        if (node == null) {
            return;
        }
        // (һ)��������������
        infixthreadedNodes(node.getLeft());
        // (��)��������ǰ���[���Ѷ�]

        // ����ǰ����ǰ�����
        // ��8�������⣬��Ϊ��һ��ʹ�÷���ʱ����һֱ�ݹ鵽8�ڵ�
        // 8����.left = null , 8����.leftType =
        // 1����ʱpre��null����null����ΪΪ8��ǰ����㣬ͬʱ��������ǰ������
        if (node.getLeft() == null) {
            // �õ�ǰ������ָ��ָ��ǰ�����
            node.setLeft(pre);
            // �޸ĵ�ǰ������ָ�������,ָ��ǰ�����
            node.setLeftType(1);
        }
        // �����̽��
        if (pre != null && pre.getRight() == null) {
            // ��ǰ��������ָ��ָ��ǰ���
            pre.setRight(node);
            // �޸�ǰ��������ָ������
            pre.setRightType(1);
        }
        // !!! ÿ����һ�������õ�ǰ�������һ������ǰ�����
        // ��һ�����8�Ĳ�����pre=null���pre=���8
        pre = node;
        // (��)��������������
        infixthreadedNodes(node.getRight());
    }

    public void prethreadedNode(HeroNode node) { // 1 3 8 10 6 14
        if (node == null) {
            return;
        }
        pre = node;
        if (node.getLeft() != null && node.getRight() != null) {
            if (node.getLeft().getRight() == null && node.getRight().getLeft() == null) {
                node.getLeft().setRight(node.getRight());
                node.getLeft().setLeftType(1);
                node.getRight().setRight(pre.getRight());
                node.getRight().setRightType(1);
            }
        }
        prethreadedNode(node.getLeft());
        prethreadedNode(node.getRight());
        if (node.getRight() != null) {
            pre.setRight(node.getRight());
        }
    }
}

// �ȴ���HeroNode ���
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; // Ĭ��null
    private HeroNode right; // Ĭ��null
    // ˵��
    // 1. ���leftType == 0 ��ʾָ�����������, ��� 1 ���ʾָ��ǰ�����
    // 2. ���rightType == 0 ��ʾָ����������, ��� 1��ʾָ���̽��
    private int leftType;
    private int rightType;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
