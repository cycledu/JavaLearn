package ThinkingInJava.Charpter15.utils;

import ThinkingInJava.Charpter15.Generator;
import ThinkingInJava.Charpter15.generics.Coffee;
import ThinkingInJava.Charpter15.generics.CoffeeGenerator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author : jingtao
 * @Data : 2020/04/11/16:56
 * @Description :
 * @Page or WebSite：366
 * @Expected result ：
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffees) {
            System.out.println(c);
        }
        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for (int i : fnumbers) {
            System.out.print(" " + i);
        }
    }
}
