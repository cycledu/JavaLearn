package ThinkingInJava.Charpter15.practise7;//: generics/IterableFibonacci.java
// Adapt the Fibonacci class to make it Iterable.

import ThinkingInJava.Charpter15.utils.Fibonacci;
//P361/练习7
import java.util.*;

public class IterableFibonacci
        implements Iterable<Integer> {
    private Fibonacci fibonacci;
    private int n;
    public IterableFibonacci(Fibonacci fibonacci, int n) {
        this.fibonacci = fibonacci;
        this.n = n;
    }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n > 0;
            }
            public Integer next() {
                n--;
                //内部类中使用外部类类名.this 访问外部类的field
                return IterableFibonacci.this.fibonacci.next();
            }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args) {
        for (int i : new IterableFibonacci(new Fibonacci(), 18))
            System.out.print(i + " ");
    }
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~
