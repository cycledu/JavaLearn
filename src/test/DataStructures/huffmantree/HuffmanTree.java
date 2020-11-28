package DataStructures.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
	public static void main(String[] args) {
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		Node creathuffmantree = creathuffmantree(arr);
		prePrder(creathuffmantree);
	}

	public static void prePrder(Node root) {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("空树");
		}
	}

	public static Node creathuffmantree(int[] arr) {
		// 第一步为了操作方便
		// 1. 遍历 arr 数组
		// 2. 将arr的每个元素构成成一个Node
		// 3. 将Node 放入到ArrayList中
		List<Node> nodes = new ArrayList<>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}
		while (nodes.size()>1) {
			Collections.sort(nodes);
			//取出nodes中权值最小的两个结点
			Node leftnode = nodes.get(0);
			Node rightnode = nodes.get(1);
			Node parent=new Node(leftnode.getValue()+rightnode.getValue());
			//设置新生成父结点的左右子结点
			parent.setLeft(leftnode);
			parent.setRgiht(rightnode);
			//删除已经使用的结点并加入新节点重新排序
			nodes.remove(0);
			nodes.remove(0);
			nodes.add(parent);
			Collections.sort(nodes);
		}
		return nodes.get(0);
	}
}

// 创建结点类
// 为了让Node 对象持续排序Collections集合排序
// 让Node 实现Comparable接口
class Node implements Comparable<Node> {
	int value;// 结点权值
	Node left;
	Node rgiht;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRgiht() {
		return rgiht;
	}

	public void setRgiht(Node rgiht) {
		this.rgiht = rgiht;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		// 表示从小到大排序
		return this.value - o.value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	public Node(int value) {
		super();
		this.value = value;
	}

	// 前序遍历
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.rgiht != null) {
			this.rgiht.preOrder();
		}
	}
}
