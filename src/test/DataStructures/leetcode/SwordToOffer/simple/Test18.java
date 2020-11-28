package DataStructures.leetcode.SwordToOffer.simple;

import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/05/24/23:54
 * @Description :
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * @Page or WebSite：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @Expected result ：
 */
public class Test18 {
    static class Solution {
        //错误
        public ListNode deleteNode(ListNode head, int val) {
            Stack<ListNode> listNodes = new Stack<>();
            ListNode temp = head;
            if (temp.val == val) {
                return temp.next;
            }
            while (temp != null) {
                listNodes.push(temp);
                if (temp.next.val == val) {
                    if (temp.next.next != null)
                        temp.next = temp.next.next;
                    else
                        temp.next = null;
                }
            }
            return head;
        }

        //双指针(使用快慢指针，快指针快一个节点，快指针找到节点，慢指针则将指向快指针的下一个节点)
        public ListNode deleteNode1(ListNode head, int val) {
            if (head.val == val)
                return head.next;
            ListNode pre = head, cur = head.next;
            //等到cur位置的值为null或者为指定的值时，跳出循环
            while (cur != null && cur.val != val) {
                pre = cur;
                cur = cur.next;
            }
            //慢指针则将指向快指针的下一个节点,快指针不在引用之内，相当于删除
            if (cur != null) pre.next = cur.next;
            return head;
        }

        //单指针（单指针向前遍历判断下一个节点的值是不是要删除的值）
        public ListNode deleteNode2(ListNode head, int val) {
            if (head == null) return null;
            if (head.val == val) return head.next;
            ListNode cur = head;
            while (cur.next != null && cur.next.val != val)
                cur = cur.next;
            if (cur.next != null)
                cur.next = cur.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
