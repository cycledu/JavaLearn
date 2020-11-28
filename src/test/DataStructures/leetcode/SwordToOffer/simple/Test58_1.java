package DataStructures.leetcode.SwordToOffer.simple;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/07/01/20:25
 * @Description :输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test58_1 {
    public String reverseWords(String s) {
        Stack<String> resultstack = new Stack<>();
        Stack<String> temp = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (String c : (sb.reverse().toString() + " ").split("")) {
            if (!c.equals(" ")) {
                temp.push(c);
                continue;
            }
            while (temp.size() > 0)
                resultstack.push(temp.pop());
            if (c.equals(" "))
                resultstack.push(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (resultstack.size() > 0)
            stringBuilder.append(resultstack.pop());
        String substring = stringBuilder.reverse().substring(0, stringBuilder.length() - 1).trim().replaceAll("\\s+", " ");
        return substring;
    }

    @Test
    public void test() {
        System.out.println(reverseWords("        I am a      student.           "));
    }
}
