package java8.concurrent.ForkJoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Author : jingtao
 * @Data : 2020/11/09/20:58
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class testForkjoin {
    @Test
    public void test1() {
        long sum = 0L;
        for (long i = 0; i < 1000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0L, 1000000000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        System.out.println(submit.get());

    }

    @Test
    public void test3() {
        System.out.println(LongStream.rangeClosed(0L, 1000000000L).parallel().reduce(0, Long::sum));
    }
}
