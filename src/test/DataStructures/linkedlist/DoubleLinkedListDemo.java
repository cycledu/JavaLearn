package DataStructures.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

		doubleLinkedList dLinkedList = new doubleLinkedList();
//		dLinkedList.add(hero1);
//		dLinkedList.add(hero3);
//		dLinkedList.add(hero4);
//		dLinkedList.add(hero2);
//		
//		dLinkedList.list();
//		
//		//修改
//		HeroNode2 newHeroNode=new HeroNode2(4, "公孙胜", "入云龙");
//		dLinkedList.update(newHeroNode);
//		System.out.println("修改后");
//		dLinkedList.list();
		
//		dLinkedList.del(3);
//		System.out.println("删除++后");
//		dLinkedList.list();
		//按顺序添加
		dLinkedList.addByOrder(hero1);
		dLinkedList.addByOrder(hero3);
		dLinkedList.addByOrder(hero4);
		dLinkedList.addByOrder(hero2);
		dLinkedList.list();
	}
}

// 创建一个双向链表的类
class doubleLinkedList {
	// 先初始化一个头节点
	private HeroNode2 head = new HeroNode2(0, "", "");

	// 返回头节点
	public HeroNode2 gethead() {
		return head;
	}

	public void addByOrder(HeroNode2 heroNode) {
		// 因为头节点不能动，因此我们通过一个辅助变量来帮助找到添加的位置
		// 因为单链表，我们找的temp是位于添加位置的前一个节点，否则插入不了
		HeroNode2 temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) { // 要插入的节点位置已找到，就再temp的后面插入
				break;
			} else if (temp.next.no == heroNode.no) {
				flag = true;// 说明编号存在
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("准备插入的英雄编号已经存在");
		} else {
			//节点为最后插入
			if (temp.next == null) {
				temp.next=heroNode;
				heroNode.pre=temp;
			}
			// 插入到表中，temp的后面
			else {
			heroNode.next = temp.next;
			temp.next.pre=heroNode;
			temp.next = heroNode;
			heroNode.pre=temp;
			}
		}
	}
	
	// 遍历链表
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
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

	// 添加一个节点到双向链表的最后
	public void add(HeroNode2 HeroNode2) {
		// 因为头节点不能动，因此我们需要一个辅助变量temp
		HeroNode2 temp = head;
		// 遍历链表找到最后
		while (true) {
			// 找到链表最后
			if (temp.next == null) {
				break;
			}
			// 如果没有找到最后，将temp后移
			temp = temp.next;
		}
		// 当退出while循环时，temp就指向了链表的最后
		// 将最后这个节点的next指向新的节点
		temp.next = HeroNode2;
		HeroNode2.pre = temp;
	}

	// 双向链表修改节点内容
	public void update(HeroNode2 newh) {
		// 判断是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 找到需要修改的节点，根据no编号
		HeroNode2 temp = head.next;
		boolean flag = false;// 表示是否找到该节点
		while (true) {
			if (temp == null) {
				break;// 已经遍历完链表
			}
			if (temp.no == newh.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 根据flag判断是否找到要修改的节点
		if (flag) {
			temp.name = newh.name;
			temp.nickname = newh.nickname;
		} else {
			System.out.println("没有找到要修改的节点");
		}
	}

	// 双向链表删除节点
	public void del(int no) {
		HeroNode2 temp = head;
		boolean flag = false;// 是否找到了需要被删除的节点
		while (true) {
			if (temp.next == null) {// 链表为空
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;// temp后移
		}
		// 判断flag
		if (flag) {
			temp.pre.next = temp.next;
			// 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针异常
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.println("没有找到要删除的节点");
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
