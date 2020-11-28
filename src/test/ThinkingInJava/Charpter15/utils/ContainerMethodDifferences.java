//: net/mindview/util/ContainerMethodDifferences.java
package ThinkingInJava.Charpter15.utils;

import java.lang.reflect.*;
import java.util.*;

public class ContainerMethodDifferences {
    static Set<String> methodSet(Class<?> type) {
        Set<String> result = new TreeSet<String>();
        for (Method m : type.getMethods())
            result.add(m.getName());
        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.print("Interfaces in " + type.getSimpleName() + ": ");
        List<String> result = new ArrayList<String>();
        for (Class<?> c : type.getInterfaces())
            result.add(c.getSimpleName());
        System.out.println(result);
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    static void
    difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
        //difference():从前一个参数的返回值（方法集合）中去除后一个参数返回值的存在的值，此处输出表示子类从父类中继承但未重写的方法
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object); // Don't show 'Object' methods
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        System.out.println("===================================================");
        difference(HashSet.class, Set.class);
        System.out.println("===================================================");
        difference(LinkedHashSet.class, HashSet.class);
        System.out.println("===================================================");
        difference(TreeSet.class, Set.class);
        System.out.println("===================================================");
        difference(List.class, Collection.class);
        System.out.println("===================================================");
        difference(ArrayList.class, List.class);
        System.out.println("===================================================");
        difference(LinkedList.class, List.class);
        System.out.println("===================================================");
        difference(Queue.class, Collection.class);
        System.out.println("===================================================");
        difference(PriorityQueue.class, Queue.class);
        System.out.println("===================================================");
        System.out.println("Map: " + methodSet(Map.class));
        System.out.println("===================================================");
        difference(HashMap.class, Map.class);
        System.out.println("===================================================");
        difference(LinkedHashMap.class, HashMap.class);
        System.out.println("===================================================");
        difference(SortedMap.class, Map.class);
        System.out.println("===================================================");
        difference(TreeMap.class, Map.class);
    }
} ///:~
