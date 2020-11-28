package java8.MultypleThread.Charpter7.threadRunSyn;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/17:30
 * @Description :
 * @Page or WebSite：P424
 * @Expected result ：
 */
public class MyService {
    private ThreadLocal<Integer> printCountLocal = new ThreadLocal<>();
    private static int currentPrintPosition = 0;
    private static int finlPrintPosition = 0;
    synchronized public void printMethod(String eachThreadPrintChar, Integer eachThreadPrintPosition) {
        printCountLocal.set(0);
        while (printCountLocal.get() < 3) {
            if (currentPrintPosition==3)
            currentPrintPosition = 0;
        }
        while (eachThreadPrintPosition - 1 % 3 != currentPrintPosition) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finlPrintPosition++;
        System.out.println(Thread.currentThread().getName() + " " + eachThreadPrintChar + "" +
                "currentPrintPosition=" + currentPrintPosition + " printCountLocal.get()=" + (printCountLocal.get() + 1) + " " +
                "finlPrintPosition=" + finlPrintPosition);
        currentPrintPosition++;
        printCountLocal.set(printCountLocal.get() + 1);
        this.notifyAll();
    }
}
