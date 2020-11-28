package DataStructures.leetcode.SwordToOffer.simple;

import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/05/26/21:44
 * @Description :
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 * @Page or WebSite：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @Expected result ：
 */
public class Test22 {
    //压入栈人后弹出
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> listNodes = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.push(temp);
            temp = temp.next;
        }
        ListNode pop = null;
        while (k != 0) {
            pop = listNodes.pop();
            k--;
        }
        return pop;
    }

    /**
     * 双指针
     * 同时有两个指针。一个先向前走k步（此时两个指针之间的距离就是从倒数第k个节点到最后的距离），
     * 然后两个指针一起往前走，直到第一个走的指针指向空时，第二个指针此时的位置就是倒数第k个节点
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode first = head, second = head;
        for (int i = 1; i <= k; i++) {
            first=first.next;
        }
        while (first!=null){
            first=first.next;
            second=second.next;
        }
        return second;
        /**
         * another
         * ListNode slow=head,fast=head;
         *         int t = 0;
         *         while(fast!=null){
         *             if(t>=k) slow=slow.next;
         *             fast = fast.next;
         *             t++;
         *         }
         *         return slow;
         */
    }
}
