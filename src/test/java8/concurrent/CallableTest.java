package java8.concurrent;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author : jingtao
 * @Data : 2020/11/23/22:11
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class CallableTest {
    class A implements Callable<Integer> {
        Random random = new Random();

        @Override
        public Integer call() throws Exception {
            return random.nextInt();
        }
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        A a = new A();
        FutureTask<Integer> futureTask = new FutureTask<>(a);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    @Test
    public void testCompeletService() throws ExecutionException, InterruptedException {
        A a = new A();
        CompletionService service = new ExecutorCompletionService<Integer>(Executors.newSingleThreadExecutor());
        Future submit = service.submit(a);
        System.out.println(submit.get());
    }

    @Test
    public void testExecutor() throws ExecutionException, InterruptedException {
        A a = new A();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println(executorService.submit(a).get());
    }
}
