package DataStructures.MyBST;

import java.util.Map;

/**
 * @Author : jingtao
 * @Data : 2020/11/01/16:54
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class AVLEntry<K, V> implements Map.Entry<K, V> {
    public K key;
    public V value;
    public AVLEntry<K, V> left;
    public AVLEntry<K, V> right;
    public int height = 1;

    @Override
    public String toString() {
        return "AVLEntry{" +
                "key=" + key +
                ", value=" + value +
                ", height=" + height +
                '}';
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    public AVLEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public AVLEntry(K key) {
        this.key = key;
    }

    public AVLEntry(K key, V value, AVLEntry left, AVLEntry right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public AVLEntry getLeft() {
        return left;
    }

    public void setLeft(AVLEntry left) {
        this.left = left;
    }

    public AVLEntry getRight() {
        return right;
    }

    public void setRight(AVLEntry right) {
        this.right = right;
    }

}
