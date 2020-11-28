package ThinkingInJava.Charpter15.utils;

import ThinkingInJava.Charpter15.Generator;

/**
 * @Author : jingtao
 * @Data : 2020/04/11/17:01
 * @Description :
 * @Page or WebSite：360
 * @Expected result ：
 */
public class Fibonacci implements Generator<Integer> {

    private int count = 0;
    @Override
    public Integer next() {
        return fib(count++);
    }
    public int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);//此时返回值是前一个位置和前前一个位置的值的和
    }
    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(gen.next() + " ");
        }
    }
}
