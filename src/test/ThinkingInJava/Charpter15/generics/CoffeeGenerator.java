package ThinkingInJava.Charpter15.generics;

import ThinkingInJava.Charpter15.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @Author : jingtao
 * @Data : 2020/04/09/20:48
 * @Description : 359
 * @Page or WebSite：
 * @Expected result ：
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class,};
    private static Random rand = new Random(47);
    private int size = 0;
    public CoffeeGenerator() {    }
    public CoffeeGenerator(int size) {
        this.size = size;
    }
    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
        @Override
        public boolean hasNext() {
            return count > 0;
        }
        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }
    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffeeGenerator.next());
        }
        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
