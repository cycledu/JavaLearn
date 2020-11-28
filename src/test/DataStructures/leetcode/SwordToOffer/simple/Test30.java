package DataStructures.leetcode.SwordToOffer.simple;

import java.util.ArrayList;

/**
 * @Author : jingtao
 * @Data : 2020/07/19/16:50
 * @Description :
 * @Page or WebSite：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @Expected result ：
 */
class MinStack {
    public ArrayList<Integer> arrayList;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.arrayList = new ArrayList<Integer>();
    }

    public void push(int x) {
        this.arrayList.add(x);
    }

    public void pop() {
        this.arrayList.remove(this.arrayList.size() - 1);
    }

    public int top() {
        return this.arrayList.get(this.arrayList.size() - 1);
    }
    public int min() {
        int i = this.arrayList.get(0);
        for (Integer a : this.arrayList) {
            if (a < i) i = a;
        }
        return i;
    }
}

public class Test30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.arrayList);
        minStack.min();
        System.out.println(minStack.arrayList);
        minStack.pop();
        System.out.println(minStack.arrayList);
        minStack.top();
        System.out.println(minStack.arrayList);
        minStack.min();
        System.out.println(minStack.arrayList);

    }
}
