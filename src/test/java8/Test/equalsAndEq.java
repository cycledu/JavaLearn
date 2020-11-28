package java8.Test;

/**
 * @Author : jingtao
 * @Data : 2020/11/01/14:59
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class equalsAndEq {
    public static void main(String[] args) {
        String A = "1";
        String B = new String("1");
        String C = B;
        System.out.println(A.equals(B));
        System.out.println(A.equals(C));
        System.out.println(B.equals(C));
    }
}
