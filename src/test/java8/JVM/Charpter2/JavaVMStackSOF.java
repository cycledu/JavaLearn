package java8.JVM.Charpter2;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/15:38
 * @Description :   -Xss160k
 * @Page or WebSite：2-4
 * @Expected result ：
 *  stack length: 2049
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at Charpter2.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:14)
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + javaVMStackSOF.stackLength);
            throw e;
        }
    }
}
