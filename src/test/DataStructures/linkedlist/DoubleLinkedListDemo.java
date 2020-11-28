package DataStructures.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");

		doubleLinkedList dLinkedList = new doubleLinkedList();
//		dLinkedList.add(hero1);
//		dLinkedList.add(hero3);
//		dLinkedList.add(hero4);
//		dLinkedList.add(hero2);
//		
//		dLinkedList.list();
//		
//		//�޸�
//		HeroNode2 newHeroNode=new HeroNode2(4, "����ʤ", "������");
//		dLinkedList.update(newHeroNode);
//		System.out.println("�޸ĺ�");
//		dLinkedList.list();
		
//		dLinkedList.del(3);
//		System.out.println("ɾ��++��");
//		dLinkedList.list();
		//��˳�����
		dLinkedList.addByOrder(hero1);
		dLinkedList.addByOrder(hero3);
		dLinkedList.addByOrder(hero4);
		dLinkedList.addByOrder(hero2);
		dLinkedList.list();
	}
}

// ����һ��˫���������
class doubleLinkedList {
	// �ȳ�ʼ��һ��ͷ�ڵ�
	private HeroNode2 head = new HeroNode2(0, "", "");

	// ����ͷ�ڵ�
	public HeroNode2 gethead() {
		return head;
	}

	public void addByOrder(HeroNode2 heroNode) {
		// ��Ϊͷ�ڵ㲻�ܶ����������ͨ��һ�����������������ҵ���ӵ�λ��
		// ��Ϊ�����������ҵ�temp��λ�����λ�õ�ǰһ���ڵ㣬������벻��
		HeroNode2 temp = head;
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
			//�ڵ�Ϊ������
			if (temp.next == null) {
				temp.next=heroNode;
				heroNode.pre=temp;
			}
			// ���뵽���У�temp�ĺ���
			else {
			heroNode.next = temp.next;
			temp.next.pre=heroNode;
			temp.next = heroNode;
			heroNode.pre=temp;
			}
		}
	}
	
	// ��������
	public void list() {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// ���һ���ڵ㵽˫����������
	public void add(HeroNode2 HeroNode2) {
		// ��Ϊͷ�ڵ㲻�ܶ������������Ҫһ����������temp
		HeroNode2 temp = head;
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
		temp.next = HeroNode2;
		HeroNode2.pre = temp;
	}

	// ˫�������޸Ľڵ�����
	public void update(HeroNode2 newh) {
		// �ж��Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽڵ㣬����no���
		HeroNode2 temp = head.next;
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

	// ˫������ɾ���ڵ�
	public void del(int no) {
		HeroNode2 temp = head;
		boolean flag = false;// �Ƿ��ҵ�����Ҫ��ɾ���Ľڵ�
		while (true) {
			if (temp.next == null) {// ����Ϊ��
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;// temp����
		}
		// �ж�flag
		if (flag) {
			temp.pre.next = temp.next;
			// ��������һ���ڵ㣬�Ͳ���Ҫִ��������仰��������ֿ�ָ���쳣
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.println("û���ҵ�Ҫɾ���Ľڵ�");
		}
	}

}

class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;

	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
