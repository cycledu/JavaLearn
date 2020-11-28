package ThinkingInJava.Charpter15.practise6;//: generics/RandomList.java

import java.math.BigDecimal;
import java.util.*;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);
    public void add(T item) {
        storage.add(item);
    }
    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }
    public static void main(String[] args) {
        RandomList rs = new RandomList();
        for (int i = 0; i < 10; i++) {
            rs.add(new Integer(i));
        }
        for (int i = 0; i < 10; i++) {
            rs.add(new Double(i));
        }
        for (int i = 0; i < 11; i++)
            System.out.print(rs.select()+"-");
    }
} /* Output:
brown over fox quick quick dog brown The brown lazy brown
*///:~
