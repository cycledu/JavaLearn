package DataStructures.leetcode.SwordToOffer.simple;

import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/05/23/10:57
 * @Description :
 * @Page or WebSite：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @Expected result ：
 */
public class Test09 {
    //200ms
    class CQueue {
        Stack s1 = null;
        Stack s2 = null;
        public CQueue() {
            s1 = new Stack();
            s2 = new Stack();
        }

        public void appendTail(int value) {
            if (s1.size() == 0 && s2.size() == 0) {
                s1.push(value);
            } else if (s1.size() != 0) {
                s1.push(value);
            } else {
                while (s2.size() != 0) {
                    s1.push(s2.pop());
                }
                s1.push(value);
            }
        }

        public int deleteHead() {
            if (s1.size() == 1) {
                return (int) s1.pop();
            } else if (s1.size() == 0 && s2.size() == 0) {
                return -1;
            } else {
                while (s1.size() != 0)
                    s2.push(s1.pop());
                return (int) s2.pop();
            }
        }
    }

    //200ms
    class CQueue1 {
        Stack<Integer> s1;
        Stack<Integer> s2;
        public CQueue1() {
            s1 = new Stack<Integer>();
            s2 = new Stack<Integer>();
        }

        public void appendTail(int value) {
            if (s2.empty())
                s1.push(value);
            else {
                while (!s2.empty()) {
                    s1.push(s2.pop());
                }
                s1.push(value);
            }
        }

        public int deleteHead() {
            if (s1.size() == 1) {
                return s1.pop();
            } else if (s1.empty() && s2.empty()) {
                return -1;
            } else {
                while (!s1.empty())
                    s2.push(s1.pop());
                return s2.pop();
            }
        }
    }

    //56ms:设置size记录元素个数，
    class CQueue2 {
        Stack<Integer> s1;
        Stack<Integer> s2;
        int size;
        public CQueue2() {
            s1 = new Stack<Integer>();
            s2 = new Stack<Integer>();
        }

        public void appendTail(int value) {
            s1.push(value);
            size++;
        }

        //当s2为空，则意味着一直在添加元素，从未删除过元素，此时全部将元素压入s2，直接弹出s2栈顶元素
        //当s2不为空，则意为前面删除过元素，直接弹出s2栈顶元素就是删除队列头元素
        public int deleteHead() {
            if (size == 0)
                return -1;
            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            size--;
            return s2.pop();

        }
    }
}
