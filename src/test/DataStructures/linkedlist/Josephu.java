package DataStructures.linkedlist;

/**
 * Josephu  问题为：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
 * 它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(10);
        circleSingleLinkedList.shwoBoy();
        circleSingleLinkedList.josephuTest(2, 1, 10);
    }

}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
    // 创建一个first节点
    private Boy first = null;

    // 添加小孩节点，构建一个环形的链表
    public void addBoy(int num) {
        if (num < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;// 辅助指针，帮助构建环形链表
        // 使用for来创建我们的环形链表
        //每一次遍历都将新加的节点和原链表形成新的环形链表：2020年10月21日23:47:47
        for (int i = 1; i <= num; i++) {
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void shwoBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curboy = first;
        while (true) {
            System.out.println("小孩的编号：" + curboy.getNo());
            if (curboy.getNext() == first) {
                break;
            }
            curboy = curboy.getNext();
        }
    }

    /**
     * @param countNum 数几下
     * @param startNo  开始数的人的编号
     * @param nums     圈子的总人数
     */
    public void josephuTest(int countNum, int startNo, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入有误");
            return;
        }
        // 创建辅助指针让其指向环形链表最后一个节点
        Boy helper = first;
        while (true) {
            //走一圈，到first前跳出：2020年10月21日23:52:26
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //first在前，helper在后同时向前走，先走到要开始的位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            //如果走到最后剩一个节点，则跳出循环
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出" + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后出圈的是" + first.getNo());
    }
}

// 创建一个boy，表示一个节点
class Boy {
    private int no;// 编号
    private Boy next;// 指向下一个节点，默认为null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy [no=" + no + ", next=" + next + "]";
    }
}
