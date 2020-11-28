package DataStructures.MyBST;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

/**
 * @Author : jingtao
 * @Data : 2020/11/01/20:04
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class TestMap {
    private static final int SUM = 10;

    @Test
    public void test() {
        AVLMap<Integer, String> avlMap = new AVLMap<>();
        Random random = new Random();
        for (int i = 0; i < SUM; i++) {
            avlMap.put(i, random.nextInt(SUM) + "");
        }
        Iterator<AVLEntry<Integer, String>> iterator = avlMap.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().key + " ");
        }
        System.out.println();
        avlMap.put(1, "a");
        System.out.println(avlMap.containsKey(1));
        System.out.println(avlMap.containsValue("2"));
    }

    @Test
    public void test2() {
        AVLMap<Integer, String> avlMap = new AVLMap<>();
        for (String s : "5261473".split("")) {
            avlMap.put(Integer.valueOf(s), s);
        }
        AVLEntry<Integer, String> root = avlMap.root;
        Iterator<AVLEntry<Integer, String>> iterator = avlMap.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().key + " ");
        }
        System.out.println();
        avlMap.levelOrder();
        avlMap.remove(4);
        System.out.println();
        avlMap.levelOrder();
    }
}
