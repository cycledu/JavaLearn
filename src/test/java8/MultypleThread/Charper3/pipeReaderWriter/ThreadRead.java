package java8.MultypleThread.Charper3.pipeReaderWriter;

import java.io.PipedReader;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/15:07
 * @Description :
 * @Page or WebSite：P254
 * @Expected result ：
 */
public class ThreadRead extends Thread {
    private ReadData readData;
    private PipedReader pipedReader;
    public ThreadRead(ReadData readData, PipedReader pipedReader) {
        this.readData = readData;
        this.pipedReader = pipedReader;
    }
    @Override
    public void run() {
        readData.readMethod(pipedReader);
    }
}
