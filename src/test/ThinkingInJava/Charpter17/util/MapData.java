//: net/mindview/util/MapData.java
// A Map filled with data using a generator object.
package ThinkingInJava.Charpter17.util;


import ThinkingInJava.Charpter15.Generator;

import java.util.*;

/**
 * 462
 *
 * @param <K>
 * @param <V>
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {

    /**
     * 将Pair中的键值对放入容器
     *
     * @param gen      生成器
     * @param quantity 长度
     */
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }
    // Two separate Generators:
    public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), genV.next());
        }
    }
    // A key Generator and a single value:
    public MapData(Generator<K> genK, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), value);
        }
    }
    // An Iterable and a value Generator:
    public MapData(Iterable<K> genK, Generator<V> genV) {
        for (K key : genK) {
            put(key, genV.next());
        }
    }
    // An Iterable and a single value:
    public MapData(Iterable<K> genK, V value) {
        for (K key : genK) {
            put(key, value);
        }
    }
    // Generic convenience methods:
    /**
     * 使用泛型的生成器和规定长度，生成容器
     */
    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData<K, V>(gen, quantity);
    }
    /**
     * 使用泛型K、V的生成器和规定长度，生成容器
     */
    public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData<K, V>(genK, genV, quantity);
    }
    /**
     * 使用K的生成器，和规定长度，放入同样的V
     */
    public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity) {
        return new MapData<K, V>(genK, value, quantity);
    }
    /**
     * 使用K的迭代器和V的生成器制造容器
     *
     * @return
     */
    public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<K, V>(genK, genV);
    }
    /**
     * 迭代所有K，放入相同的V
     *
     * @return
     */
    public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
        return new MapData<K, V>(genK, value);
    }
} ///:~
