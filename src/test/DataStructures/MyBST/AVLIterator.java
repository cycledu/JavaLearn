package DataStructures.MyBST;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/11/01/17:08
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class AVLIterator<K, V> implements Iterator<AVLEntry<K, V>> {
    private Stack<AVLEntry<K, V>> stack;

    public AVLIterator(AVLEntry<K, V> root) {
        stack = new Stack<AVLEntry<K, V>>();
        addLeftPath(root);
    }

    private void addLeftPath(AVLEntry<K, V> p) {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public AVLEntry<K, V> next() {
        AVLEntry<K, V> p = stack.pop();
        addLeftPath(p.right);
        return p;
    }
}
