package DataStructures.leetcode.SwordToOffer.simple;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/05/26/22:09
 * @Description :
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Page or WebSite：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @Expected result ：
 */
public class Test24 {
    //错误
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> listNodes = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.push(temp);
            temp = temp.next;
        }
        head.next = null;
        ListNode newhead = listNodes.pop(), newheadtemp = listNodes.pop();
        while (listNodes.size() != 0) {
            newhead.next = listNodes.pop();
            newhead = newhead.next;
        }
        return newheadtemp;
    }
    //错误
    public ListNode reverseList1(ListNode head) {
        List<ListNode> listNodes = new LinkedList<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.add(temp);
            temp = temp.next;
        }
        listNodes.get(0).next = null;
        ListIterator<ListNode> listIterator = listNodes.listIterator(listNodes.size() - 1);
        ListNode newhead = listIterator.previous(), newhead1 = listIterator.previous();
        while (listIterator.hasPrevious()) {
            newhead.next = listIterator.previous();
            newhead = newhead.next;
        }
        return newhead1;
    }

    //双指针前移并局部反转
    public ListNode reverseList2(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            //局部反转前先向前移动并保存
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }
    //递归
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode nh = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return nh;
    }

    //妖魔化的双指针
    public ListNode reverseList4(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        while (head.next != null) {
            ListNode t = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = t;
        }
        return cur;
    }
    /**
     * 妖魔化的双指针:
     * 原链表的头结点就是反转之后链表的尾结点，使用 head  标记 .
     * 定义指针 cur ，初始化为 head .
     * 每次都让 head  下一个结点的 next  指向 cur   ，实现一次局部反转
     * 局部反转完成之后，cur  和 head  的 next  指针同时 往前移动一个位置
     * 循环上述过程，直至 cur 到达链表的最后一个结点 .
     * class Solution {
     * public:
     *     ListNode* reverseList(ListNode* head) {
     *         if (head == NULL) { return NULL; }
     *         ListNode* cur = head;
     *         while (head->next != NULL) {
     *             ListNode* t = head->next->next;
     *             head->next->next = cur;
     *             cur = head->next;
     *             head->next = t;
     *         }
     *         return cur;
     *     }
     * };
     */
}
