package DataStructures.stack;

public class ArrayStack {
	public static void main(String[] args) {
		stack s = new stack(4);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.list();
		System.out.println();
		s.pop();
		s.list();
	}
}

class stack {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public stack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	public boolean isfull() {
		return top == maxSize - 1;
	}

	public boolean isempty() {
		return top == -1;
	}

	public void push(int value) {
		if (isfull()) {
			System.out.println("Õ»Âú");
			return;
		} else {
			top++;
			stack[top] = value;
		}
	}

	public int pop() {
		if (isempty()) {
			throw new RuntimeException("Õ»¿Õ");
		}
		int val = stack[top];
		top--;
		return val;
	}

	public void list() {
		if (isempty()) {
			throw new RuntimeException("Õ»¿Õ");
		}
		for (int i = top; i >= 0; i--) {
			System.out.println("stack=" + stack[i]);
		}
	}
}
