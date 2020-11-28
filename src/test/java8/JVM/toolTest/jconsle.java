package java8.JVM.toolTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/11/01/14:33
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class jconsle {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        while (true) {
            Thread.sleep(3000);
            list.add(1);
        }
    }
}
