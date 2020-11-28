package ThinkingInJava.Charpter16.util;


import ThinkingInJava.Charpter16.CountingGenerator;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/22:01
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class TestGenerated {
    public static void main(String[] args) {
        Integer a[] = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));
        a = Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));
        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        System.out.println(Arrays.toString(b));
    }
}
