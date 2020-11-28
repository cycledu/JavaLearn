package ThinkingInJava.Charpter16.util;

import ThinkingInJava.Charpter15.Generator;
import ThinkingInJava.Charpter16.CollectionData;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/21:53
 * @Description :
 * @Page or WebSite：P447
 * @Expected result ：
 */
public class Generated {
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }
}
