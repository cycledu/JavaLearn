package DataStructures.leetcode.SwordToOffer.simple;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/05/22/23:10
 * @Description :
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * @Page or WebSite：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @Expected result ：
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    @Override
    public String toString() {
        return "val=" + val + "--> next=" + next;
    }
}
public class Test06 {
    //2ms
    public int[] reversePrint(ListNode head) {
        int num = 1;
        //防止空Node进行判断
        if (head == null) {
            return new int[]{};
        }
        List<Integer> listNodes = new ArrayList<>();
        //如果只有一个节点，不会进入
        //判断如果下一个节点不为空时，进入，最后一个节点就不能进行操作
        while (head.next != null) {
            listNodes.add(head.val);
            head = head.next;
            num++;
        }
        //进行最后一个节点的取值，若只有一个节点，就只进行这一次取值
        listNodes.add(head.val);
        int[] a = new int[num];
        Collections.reverse(listNodes);
        for (int i = 0; i < listNodes.size(); i++) {
            a[i] = listNodes.get(i);
        }
        return a;
    }

    //1ms：只对当前节点的对象进行判断
    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        //如果节点不是空。就压入栈
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        //依次弹出放入数组
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(3);
        n1.next.next = new ListNode(2);
        Test06 test06 = new Test06();
        System.out.println(Arrays.toString(test06.reversePrint(n1)));
    }
}
