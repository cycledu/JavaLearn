package DataStructures.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(4);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s:显示队列");
			System.out.println("e:退出队列");
			System.out.println("a:添加数据到队列");
			System.out.println("g:获取队列数据");
			System.out.println("h:查看队列头数据");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			case 'a':
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					System.out.printf(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("队列的头数据是%d\n", res);
				} catch (Exception e) {
					System.out.printf(e.getMessage());
				}
				break;
			}
		}
		System.out.println("程序退出");
	}
}

// 使用数组模拟队列，编写一个ArrayQueue类
class ArrayQueue {
	private int maxSize;// 表示数组的最大容量
	private int front;// 队列头
	private int rear;// 队列尾
	private int[] arr;// 用于存放数据，模拟队列

	// 创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}

	// 判断队列是否为满
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 添加数据到队列
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("队列满，不能加数据");
			return;
		}
		arr[rear] = n;// 直接将数据加入
		
		//若rear已指向最后一个数值，该步骤操作后，相当于又将rear指向第一个数组元素，由此配合front的后移操作从而实现了rear对于数组中元素的循环指向动作
		rear = (rear + 1) % maxSize;// 将rear后移，这里必须考虑取模
	}

	// 获取队列数据,出队列
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列空。不能取数据");
		}
		// 分析出froont是指向队列的第一个元素
		// 1.先front对应的值保存到临时变量
		// 2.front后移
		// 3.返回临时变量
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// 显示队列所有数据
	public void showQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列空。没有数据");
		}
		// 从front开始遍历

		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	// 求当前队列有效数据个数
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

	// 显示队列头数据，不是取数据
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列空。没有数据");
		}
		return arr[front];
	}
}