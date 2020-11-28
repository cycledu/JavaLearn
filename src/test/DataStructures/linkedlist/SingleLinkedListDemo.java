package DataStructures.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

		// 创建链表
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

		HeroNode hero = new HeroNode(3, "乌龙", "豹神圣子头");

		singLinkedList.update(hero);

		System.out.println("修改后的");
		singLinkedList.list();
//
//		System.out.println("删除节点");
//		singLinkedList.del(2);
//		singLinkedList.list();

		System.out.println("链表的有效接节点个数为：" + singLinkedList.getlength(singLinkedList.gethead()));
		
		HeroNode res=singLinkedList.findLastIndexNode(singLinkedList.gethead(), 3);
		System.out.println(res);
		
//		System.out.println("反转后的链表为");
//		singLinkedList.reverseList(singLinkedList.gethead());
//		singLinkedList.list();
		
		singLinkedList.reversePrint(singLinkedList.gethead());
	}

}

// 创建单链表
class SingLinkedList {

	// 初始化头节点
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode gethead() {
		return head;
	}

	// 添加节点到单向链表
	// 思路：当不考虑编号顺序时
	// 1.找到当前链表的最后节点
	// 2.将最后这个节点的next指向新的节点
	public void add(HeroNode heroNode) {
		// 因为头节点不能动，因此我们需要一个辅助变量temp
		HeroNode temp = head;
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
		temp.next = heroNode;
	}

	// 第二种方式在添加英雄是，根据排名将英雄插入到指定位置
	// （如果有这个排名，则添加失败，并给出提示）
	public void addByOrder(HeroNode heroNode) {
		// 因为头节点不能动，因此我们通过一个辅助变量来帮助找到添加的位置
		// 因为单链表，我们找的temp是位于添加位置的前一个节点，否则插入不了
		HeroNode temp = head;
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
			// 插入到表中，temp的后面
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	// 修改节点的信息
	// 1.根据newHeroNode的no来修改即可
	public void update(HeroNode newh) {
		// 判断是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 找到需要修改的节点，根据no编号
		HeroNode temp = head.next;
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

	// 显示链表
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
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

	// 删除节点
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;// 是否找到了需要被删除的节点
		while (true) {
			if (temp.next == null) {// 链表为空
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;// temp后移
		}
		// 判断flag
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.println("没有找到要删除的节点");
		}
	}

	/**
	 * 
	 * @param head
	 *            链表的头节点
	 * @return 返回有效节点的个数
	 */
	public static int getlength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		// 定义一个辅助变量，从辅助变量开始时进行数值叠加
		HeroNode cur = head.next;
		while (cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}

	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		// 如果链表为空，返回空
		if (head.next == null) {
			System.out.println("链表为空");
		}
		// 第一次遍历得到链表的长度
		int size = getlength(head);
		// 第二次遍历size-head位置，就是我们倒数的第k个节点
		// 先做一个index的校验
		if (index <= 0 || index > size) {
			return null;
		}
		// 定义给辅助变量，for循环定位到倒数的index
		HeroNode cur = head.next;
		for (int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}
	
	/**
	 * 将单链表进行反转
	 */
	public static void reverseList(HeroNode head){
		//如果链表为空，直接返回
		if (head.next==null || head.next.next==null) {
			return;
		}
		//定义一个临时变量
		HeroNode cur=head.next;
		HeroNode next=null;
		HeroNode reverseHead=new HeroNode(0, "", "");
		//遍历原来的链表，将每一个节点都插到新链表的最前端
		while(cur!=null){
			next=cur.next;//先保存当前节点的下一个节点
			cur.next=reverseHead.next;//将新链表最前端的节点赋给cur.next
			reverseHead.next=cur;
			cur=next;//让cur后移
		}
		//将原链表的头节点指向新链表的有效数据的部分
		head.next=reverseHead.next;
	}
	
	/**
	 * 使用栈逆序打印输出
	 */
	public static void reversePrint(HeroNode head){
		if (head.next==null) {
			return;
		}
		//创建栈，压入节点
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

// 定义HeroNode，每个HeroNode对象就是一个节点
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