package java8.concurrent.ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Author : jingtao
 * @Data : 2020/11/09/20:46
 * @Description :求和计算的任务
 * forkjoinpool 来执行 forkjointask
 * @PageOrWebSite：
 * @Expected result ：
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private long start;
    private long end;
    private long temp = 10000L;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
