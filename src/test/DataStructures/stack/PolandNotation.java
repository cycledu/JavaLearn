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

	// 将表达式分割放入list中
	public static List<String> getStringList(String string) {
		String[] s = string.split(" ");
		List<String> list = new ArrayList<>();
		for (String string2 : s) {
			list.add(string2);
		}
		return list;
	}

	// 从list中取值通过栈来计算
	public static int calculate(List<String> stringList) {

		Stack<String> stack = new Stack<>();
		int num1 = 0;
		int num2 = 0;
		// 从左到右扫描
		for (String string : stringList) {
			// 遇数入栈
			if (string.matches("\\d+")) {
				stack.add(string);
			} else {
				// 非数则pop出栈中已有的两个数，先计算再入栈
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