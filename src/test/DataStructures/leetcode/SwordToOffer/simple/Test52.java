package DataStructures.leetcode.SwordToOffer.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : jingtao
 * @Data : 2020/07/13/22:26
 * @Description :52. 两个链表的第一个公共节点
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test52 {
    /**
     * 使用set，先判空，再依次添加两链表的hash值（hash值唯一），若存在添加失败，则表示添加过一次，即操作的为公共节点元素
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode tempA = headA, tempB = headB;
        while (tempA.next != null) {
            set.add(tempA.hashCode());
            tempA = tempA.next;
        }
        while (tempB.next != null) {
            if (!set.add(tempB.hashCode())) return tempB;
            tempB = tempB.next;
        }
        return tempB.equals(tempA) ? tempA : null;
    }

    //双指针feng分别同时走两条链表，直到相遇则为公共节点
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node1 = headA;
        ListNode node2 = headB;

        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }
}