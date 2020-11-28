package DataStructures.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

		// ��������
		SingLinkedList singLinkedList = new SingLinkedList();
		//
		// singLinkedList.add(hero1);
		// singLinkedList.add(hero2);
		// singLinkedList.add(hero3);
		// singLinkedList.add(hero4);

		singLinkedList.addByOrder(hero1);
		singLinkedList.addByOrder(hero4);
		singLinkedList.addByOrder(hero3);
		singLinkedList.addByOrder(hero2);

		singLinkedList.list();

		HeroNode hero = new HeroNode(3, "����", "����ʥ��ͷ");

		singLinkedList.update(hero);

		System.out.println("�޸ĺ��");
		singLinkedList.list();
//
//		System.out.println("ɾ���ڵ�");
//		singLinkedList.del(2);
//		singLinkedList.list();

		System.out.println("�������Ч�ӽڵ����Ϊ��" + singLinkedList.getlength(singLinkedList.gethead()));
		
		HeroNode res=singLinkedList.findLastIndexNode(singLinkedList.gethead(), 3);
		System.out.println(res);
		
//		System.out.println("��ת�������Ϊ");
//		singLinkedList.reverseList(singLinkedList.gethead());
//		singLinkedList.list();
		
		singLinkedList.reversePrint(singLinkedList.gethead());
	}

}

// ����������
class SingLinkedList {

	// ��ʼ��ͷ�ڵ�
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode gethead() {
		return head;
	}

	// ��ӽڵ㵽��������
	// ˼·���������Ǳ��˳��ʱ
	// 1.�ҵ���ǰ��������ڵ�
	// 2.���������ڵ��nextָ���µĽڵ�
	public void add(HeroNode heroNode) {
		// ��Ϊͷ�ڵ㲻�ܶ������������Ҫһ����������temp
		HeroNode temp = head;
		// ���������ҵ����
		while (true) {
			// �ҵ��������
			if (temp.next == null) {
				break;
			}
			// ���û���ҵ���󣬽�temp����
			temp = temp.next;
		}
		// ���˳�whileѭ��ʱ��temp��ָ������������
		// ���������ڵ��nextָ���µĽڵ�
		temp.next = heroNode;
	}

	// �ڶ��ַ�ʽ�����Ӣ���ǣ�����������Ӣ�۲��뵽ָ��λ��
	// ���������������������ʧ�ܣ���������ʾ��
	public void addByOrder(HeroNode heroNode) {
		// ��Ϊͷ�ڵ㲻�ܶ����������ͨ��һ�����������������ҵ���ӵ�λ��
		// ��Ϊ�����������ҵ�temp��λ�����λ�õ�ǰһ���ڵ㣬������벻��
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) { // Ҫ����Ľڵ�λ�����ҵ�������temp�ĺ������
				break;
			} else if (temp.next.no == heroNode.no) {
				flag = true;// ˵����Ŵ���
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("׼�������Ӣ�۱���Ѿ�����");
		} else {
			// ���뵽���У�temp�ĺ���
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	// �޸Ľڵ����Ϣ
	// 1.����newHeroNode��no���޸ļ���
	public void update(HeroNode newh) {
		// �ж��Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽڵ㣬����no���
		HeroNode temp = head.next;
		boolean flag = false;// ��ʾ�Ƿ��ҵ��ýڵ�
		while (true) {
			if (temp == null) {
				break;// �Ѿ�����������
			}
			if (temp.no == newh.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// ����flag�ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if (flag) {
			temp.name = newh.name;
			temp.nickname = newh.nickname;
		} else {
			System.out.println("û���ҵ�Ҫ�޸ĵĽڵ�");
		}
	}

	// ��ʾ����
	public void list() {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// ɾ���ڵ�
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;// �Ƿ��ҵ�����Ҫ��ɾ���Ľڵ�
		while (true) {
			if (temp.next == null) {// ����Ϊ��
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;// temp����
		}
		// �ж�flag
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.println("û���ҵ�Ҫɾ���Ľڵ�");
		}
	}

	/**
	 * 
	 * @param head
	 *            �����ͷ�ڵ�
	 * @return ������Ч�ڵ�ĸ���
	 */
	public static int getlength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		// ����һ�������������Ӹ���������ʼʱ������ֵ����
		HeroNode cur = head.next;
		while (cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}

	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		// �������Ϊ�գ����ؿ�
		if (head.next == null) {
			System.out.println("����Ϊ��");
		}
		// ��һ�α����õ�����ĳ���
		int size = getlength(head);
		// �ڶ��α���size-headλ�ã��������ǵ����ĵ�k���ڵ�
		// ����һ��index��У��
		if (index <= 0 || index > size) {
			return null;
		}
		// ���������������forѭ����λ��������index
		HeroNode cur = head.next;
		for (int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}
	
	/**
	 * ����������з�ת
	 */
	public static void reverseList(HeroNode head){
		//�������Ϊ�գ�ֱ�ӷ���
		if (head.next==null || head.next.next==null) {
			return;
		}
		//����һ����ʱ����
		HeroNode cur=head.next;
		HeroNode next=null;
		HeroNode reverseHead=new HeroNode(0, "", "");
		//����ԭ����������ÿһ���ڵ㶼�嵽���������ǰ��
		while(cur!=null){
			next=cur.next;//�ȱ��浱ǰ�ڵ����һ���ڵ�
			cur.next=reverseHead.next;//����������ǰ�˵Ľڵ㸳��cur.next
			reverseHead.next=cur;
			cur=next;//��cur����
		}
		//��ԭ�����ͷ�ڵ�ָ�����������Ч���ݵĲ���
		head.next=reverseHead.next;
	}
	
	/**
	 * ʹ��ջ�����ӡ���
	 */
	public static void reversePrint(HeroNode head){
		if (head.next==null) {
			return;
		}
		//����ջ��ѹ��ڵ�
		Stack<HeroNode>stack=new Stack<>();
		HeroNode cur=head.next;
		while (cur!=null) {
			stack.push(cur);
			cur=cur.next;
		}
		while (stack.size()>0) {
			System.err.println(stack.pop());
		}
	}
}

// ����HeroNode��ÿ��HeroNode�������һ���ڵ�
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}