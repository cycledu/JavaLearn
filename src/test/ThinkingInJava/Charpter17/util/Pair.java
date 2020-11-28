//: net/mindview/util/Pair.java
package ThinkingInJava.Charpter17.util;

/**
 * 462
 * @param <K>
 * @param <V>
 */
public class Pair<K, V> {
    public final K key;
    public final V value;
    public Pair(K k, V v) {
        key = k;
        value = v;
    }
} ///:~
