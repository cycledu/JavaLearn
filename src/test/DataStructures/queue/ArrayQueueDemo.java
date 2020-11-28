package DataStructures.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(4);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s:��ʾ����");
			System.out.println("e:�˳�����");
			System.out.println("a:������ݵ�����");
			System.out.println("g:��ȡ��������");
			System.out.println("h:�鿴����ͷ����");
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
				System.out.println("���һ����");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					System.out.printf(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("���е�ͷ������%d\n", res);
				} catch (Exception e) {
					System.out.printf(e.getMessage());
				}
				break;
			}
		}
		System.out.println("�����˳�");
	}
}

// ʹ������ģ����У���дһ��ArrayQueue��
class ArrayQueue {
	private int maxSize;// ��ʾ������������
	private int front;// ����ͷ
	private int rear;// ����β
	private int[] arr;// ���ڴ�����ݣ�ģ�����

	// �������еĹ�����
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// ������ݵ�����
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("�����������ܼ�����");
			return;
		}
		arr[rear] = n;// ֱ�ӽ����ݼ���
		
		//��rear��ָ�����һ����ֵ���ò���������൱���ֽ�rearָ���һ������Ԫ�أ��ɴ����front�ĺ��Ʋ����Ӷ�ʵ����rear����������Ԫ�ص�ѭ��ָ����
		rear = (rear + 1) % maxSize;// ��rear���ƣ�������뿼��ȡģ
	}

	// ��ȡ��������,������
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("���пա�����ȡ����");
		}
		// ������froont��ָ����еĵ�һ��Ԫ��
		// 1.��front��Ӧ��ֵ���浽��ʱ����
		// 2.front����
		// 3.������ʱ����
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// ��ʾ������������
	public void showQueue() {
		if (isEmpty()) {
			throw new RuntimeException("���пա�û������");
		}
		// ��front��ʼ����

		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}

	// ��ǰ������Ч���ݸ���
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

	// ��ʾ����ͷ���ݣ�����ȡ����
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("���пա�û������");
		}
		return arr[front];
	}
}