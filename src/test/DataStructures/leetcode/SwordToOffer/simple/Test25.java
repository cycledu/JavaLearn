package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/05/27/21:17
 * @Description :
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Page or WebSite：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @Expected result ：
 */
public class Test25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head0 = new ListNode(0), temp = head0;
        //找到两个链表中较小的值的节点，跟到temp后面，这个链表的指针向后移动一位
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            //将依次循环后temp的指针向后移动
            temp = temp.next;
        }
        //最后将两条链表中有剩余节点的链表直接加到temp后面
        temp.next = l1 != null ? l1 : l2;
        return head0.next;
    }

    //递归
    /**
     * 编写递归的第一步，应当是明确当前函数应当完成的功能。
     * 函数功能：
     * 返回 l1指向的结点和 l2指向的结点中，值较小的结点
     * 并将从下级函数获得的返回值，链接到当前结点尾部
     * 函数结束条件：
     * 当 l1为空，或 l2为空，函数结束
     * 返回 l1 或  l2中剩下的部分
     *
     */
}
