package DataStructures.Tree;

/**
 * ˳��洢������
 * �����鴢�����ȫ����������ǰ������ͺ���ı���
 */
public class ArrayBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
		// ǰ�����
		System.out.print("ǰ��");
		arrayBinaryTree.preOrder();
		System.out.println();
		// �������
		System.out.print("�У�");
		arrayBinaryTree.infixOrder();
		System.out.println();
		// �������
		System.out.print("��");
		arrayBinaryTree.postOrder();

	}
}

class ArrayBinaryTree {
	private int[] arr;

	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}

	public void preOrder() {
		this.preOrder(0);
	}

	public void infixOrder() {
		this.infixOrder(0);
	}

	public void postOrder() {
		this.postOrder(0);
	}

	// ��������Ϊ������ǰ�����
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ��");
		}
		// ǰ���������������ڵ�Ԫ�أ��ٵݹ����ҽڵ����Ԫ��
		System.out.print(arr[index] + " ");
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}
	}

	// ��������Ϊ�������������
	public void infixOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ��");
		}
		if ((index * 2 + 1) < arr.length) {
			infixOrder(index * 2 + 1);
		}
		// �ȵݹ���ڵ�Ԫ���������������ڵ㣬�ٵݹ�����ҽڵ�Ԫ��
		System.out.print(arr[index] + " ");
		if ((index * 2 + 2) < arr.length) {
			infixOrder(index * 2 + 2);
		}
	}

	// ��������Ϊ������ǰ�����
	public void postOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ��");
		}
		if ((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}
		// �ȵݹ������ӽڵ�Ԫ�أ���������ڵ�Ԫ��
		System.out.print(arr[index] + " ");
	}

}
