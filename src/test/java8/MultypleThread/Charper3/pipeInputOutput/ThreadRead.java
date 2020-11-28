package java8.MultypleThread.Charper3.pipeInputOutput;

import java.io.PipedInputStream;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/14:44
 * @Description :
 * @Page or WebSite：P251
 * @Expected result ：
 */
public class ThreadRead extends Thread{
    private ReadData readData;
    private PipedInputStream pipedInputStream;
    public ThreadRead(ReadData readData, PipedInputStream pipedInputStream) {
        this.readData = readData;
        this.pipedInputStream = pipedInputStream;
    }
    @Override
    public void run() {
        readData.readMethod(pipedInputStream);
    }
}
