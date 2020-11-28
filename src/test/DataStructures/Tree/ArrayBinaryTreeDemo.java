package DataStructures.Tree;

/**
 * 顺序存储二叉树
 * 对数组储存的完全二叉树进行前序、中序和后序的遍历
 */
public class ArrayBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
		// 前序遍历
		System.out.print("前：");
		arrayBinaryTree.preOrder();
		System.out.println();
		// 中序遍历
		System.out.print("中：");
		arrayBinaryTree.infixOrder();
		System.out.println();
		// 后序遍历
		System.out.print("后：");
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

	// 让数组作为二叉树前序遍历
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空");
		}
		// 前序遍历：先输出根节点元素，再递归左右节点输出元素
		System.out.print(arr[index] + " ");
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}
	}

	// 让数组作为二叉树中序遍历
	public void infixOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空");
		}
		if ((index * 2 + 1) < arr.length) {
			infixOrder(index * 2 + 1);
		}
		// 先递归左节点元素输出，再输出根节点，再递归输出右节点元素
		System.out.print(arr[index] + " ");
		if ((index * 2 + 2) < arr.length) {
			infixOrder(index * 2 + 2);
		}
	}

	// 让数组作为二叉树前序遍历
	public void postOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空");
		}
		if ((index * 2 + 1) < arr.length) {
			postOrder(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			postOrder(index * 2 + 2);
		}
		// 先递归左右子节点元素，再输出根节点元素
		System.out.print(arr[index] + " ");
	}

}
