package DataStructures.leetcode.interview;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/11/24/17:58
 * @Description :
 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
 * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
 * @PageOrWebSite��
 * @Expected result ��
 */
public class test1625 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));


    }
}

class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // ʹ��αͷ����αβ���ڵ�
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // ��� key ���ڣ���ͨ����ϣ��λ�����Ƶ�ͷ��
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // ��� key �����ڣ�����һ���µĽڵ�
            DLinkedNode newNode = new DLinkedNode(key, value);
            // ��ӽ���ϣ��
            cache.put(key, newNode);
            // �����˫�������ͷ��
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // �������������ɾ��˫�������β���ڵ�
                DLinkedNode tail = removeTail();
                // ɾ����ϣ���ж�Ӧ����
                cache.remove(tail.key);
                --size;
            }
        } else {
            // ��� key ���ڣ���ͨ����ϣ��λ�����޸� value�����Ƶ�ͷ��
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
