package DataStructures.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : jingtao
 * @Data : 2020/11/24/21:17
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class test1625Test {
    public static void main(String[] args) {
        LruCache lruCache = new LruCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }
}

class LruCache {
    class node {
        int value;
        int key;
        node pre;
        node next;

        public node() {
        }

        public node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int size;
    int capacity;
    node head, tail;
    Map<Integer, node> cache = new HashMap<Integer, node>();

    public LruCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new node();
        tail = new node();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node newnode = new node(key, value);
            cache.put(key, newnode);
            size++;
            addToHead(newnode);
            if (size > capacity) {
                node tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }

    private node removeTail() {
        node pre = tail.pre;
        removeNode(pre);
        return pre;
    }
}
