package DataStructures.linkedlist;

/**
 * Josephu  ����Ϊ������Ϊ1��2���� n��n����Χ��һȦ��Լ�����Ϊk��1<=k<=n�����˴�1��ʼ����������m ���Ǹ��˳��У�
 * ������һλ�ִ�1��ʼ����������m���Ǹ����ֳ��У��������ƣ�ֱ�������˳���Ϊֹ���ɴ˲���һ�����ӱ�ŵ����С�
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(10);
        circleSingleLinkedList.shwoBoy();
        circleSingleLinkedList.josephuTest(2, 1, 10);
    }

}

// ����һ�����εĵ�������
class CircleSingleLinkedList {
    // ����һ��first�ڵ�
    private Boy first = null;

    // ���С���ڵ㣬����һ�����ε�����
    public void addBoy(int num) {
        if (num < 1) {
            System.out.println("nums��ֵ����ȷ");
            return;
        }
        Boy curBoy = null;// ����ָ�룬����������������
        // ʹ��for���������ǵĻ�������
        //ÿһ�α��������¼ӵĽڵ��ԭ�����γ��µĻ�������2020��10��21��23:47:47
        for (int i = 1; i <= num; i++) {
            // ���ݱ�ţ�����С���ڵ�
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
            System.out.println("����Ϊ��");
            return;
        }
        Boy curboy = first;
        while (true) {
            System.out.println("С���ı�ţ�" + curboy.getNo());
            if (curboy.getNext() == first) {
                break;
            }
            curboy = curboy.getNext();
        }
    }

    /**
     * @param countNum ������
     * @param startNo  ��ʼ�����˵ı��
     * @param nums     Ȧ�ӵ�������
     */
    public void josephuTest(int countNum, int startNo, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("��������");
            return;
        }
        // ��������ָ������ָ�����������һ���ڵ�
        Boy helper = first;
        while (true) {
            //��һȦ����firstǰ������2020��10��21��23:52:26
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //first��ǰ��helper�ں�ͬʱ��ǰ�ߣ����ߵ�Ҫ��ʼ��λ��
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            //����ߵ����ʣһ���ڵ㣬������ѭ��
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("��" + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("����Ȧ����" + first.getNo());
    }
}

// ����һ��boy����ʾһ���ڵ�
class Boy {
    private int no;// ���
    private Boy next;// ָ����һ���ڵ㣬Ĭ��Ϊnull

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
