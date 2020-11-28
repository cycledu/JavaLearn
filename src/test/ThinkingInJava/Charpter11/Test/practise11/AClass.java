package ThinkingInJava.Charpter11.Test.practise11;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/14:56
 * @Description :
 * @Page or WebSite：P227/练习11
 * @Expected result ：
 */
public class AClass {
    public static void print(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<>();
        Set<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            String substring = (Math.random() * 100 + " ").substring(0, 1);
            arrayList.add(substring);
            linkedList.add(substring);
            hashSet.add(substring);
            treeSet.add(substring);
        }
        print(arrayList);
        print(linkedList);
        print(hashSet);
        print(treeSet);

    }
}
