package ThinkingInJava.Charpter13;

import java.util.Scanner;

/**
 * @Author : jingtao
 * @Data : 2020/04/06/21:29
 * @Description :
 * @Page or WebSite：311
 * @Expected result ：
 */
public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner.useDelimiter("\\s*,\\s*"); //使用逗号前后的任意空白字符设置分割，line16效果一样，但未使用正则表达式，有局限性
//        scanner.useDelimiter(", ");
        while(scanner.hasNextInt()){
            System.out.println(scanner.nextInt());
        }
    }
}
