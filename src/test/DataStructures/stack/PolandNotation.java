package DataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {
		String suffixExpression = "30 4 + 5 * 6 -"; // (30+4)*5-6=164
		List<String> stringList = getStringList(suffixExpression);
		int calculate = calculate(stringList);
		System.out.println(calculate);
	}

	// �����ʽ�ָ����list��
	public static List<String> getStringList(String string) {
		String[] s = string.split(" ");
		List<String> list = new ArrayList<>();
		for (String string2 : s) {
			list.add(string2);
		}
		return list;
	}

	// ��list��ȡֵͨ��ջ������
	public static int calculate(List<String> stringList) {

		Stack<String> stack = new Stack<>();
		int num1 = 0;
		int num2 = 0;
		// ������ɨ��
		for (String string : stringList) {
			// ������ջ
			if (string.matches("\\d+")) {
				stack.add(string);
			} else {
				// ������pop��ջ�����е����������ȼ�������ջ
				num1 = Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				if (string.equals("+")) {
					int res = num1 + num2;
					stack.add(Integer.toString(res));
				} else if (string.equals("-")) {
					int res = num2 - num1;
					stack.add(Integer.toString(res));
				} else if (string.equals("*")) {
					int res = num2 * num1;
					stack.add(Integer.toString(res));
				} else if (string.equals("/")) {
					int res = num2 / num1;
					stack.add(Integer.toString(res));
				}
			}
		}
		return Integer.parseInt(stack.peek());

	}
}