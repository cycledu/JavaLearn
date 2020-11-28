package java8.MultypleThread.Charpter7.threadRunSyn;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/17:39
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class MyThread extends Thread {
    private MyService service;
    private String eachThreadPrintChar;
    private Integer eachThreadPrintPosition;
    public MyThread(MyService service, String eachThreadPrintChar, Integer eachThreadPrintPosition) {
        super();
        this.service = service;
        this.eachThreadPrintChar = eachThreadPrintChar;
        this.eachThreadPrintPosition = eachThreadPrintPosition;
    }
    @Override
    public void run() {
        service.printMethod(eachThreadPrintChar, eachThreadPrintPosition);
    }
}
