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
			System.out.println("����");
		}
	}

	public static Node creathuffmantree(int[] arr) {
		// ��һ��Ϊ�˲�������
		// 1. ���� arr ����
		// 2. ��arr��ÿ��Ԫ�ع��ɳ�һ��Node
		// 3. ��Node ���뵽ArrayList��
		List<Node> nodes = new ArrayList<>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}
		while (nodes.size()>1) {
			Collections.sort(nodes);
			//ȡ��nodes��Ȩֵ��С���������
			Node leftnode = nodes.get(0);
			Node rightnode = nodes.get(1);
			Node parent=new Node(leftnode.getValue()+rightnode.getValue());
			//���������ɸ����������ӽ��
			parent.setLeft(leftnode);
			parent.setRgiht(rightnode);
			//ɾ���Ѿ�ʹ�õĽ�㲢�����½ڵ���������
			nodes.remove(0);
			nodes.remove(0);
			nodes.add(parent);
			Collections.sort(nodes);
		}
		return nodes.get(0);
	}
}

// ���������
// Ϊ����Node �����������Collections��������
// ��Node ʵ��Comparable�ӿ�
class Node implements Comparable<Node> {
	int value;// ���Ȩֵ
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
		// ��ʾ��С��������
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

	// ǰ�����
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
