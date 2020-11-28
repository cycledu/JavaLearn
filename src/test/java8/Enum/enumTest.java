package java8.Enum;

/**
 * @Author : jingtao
 * @Data : 2020/11/10/9:41
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public enum enumTest {
    A,
    B,
    C;

    public static void main(String[] args) {
        for (enumTest value : enumTest.values()) {
            System.out.println(value);
        }
        System.out.println(enumTest.A.ordinal());
        enumTest a = valueOf("B");
        System.out.println(a);
    }
}
