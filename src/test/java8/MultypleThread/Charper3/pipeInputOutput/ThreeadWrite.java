package java8.MultypleThread.Charper3.pipeInputOutput;

import java.io.PipedOutputStream;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/14:40
 * @Description :
 * @Page or WebSite：P252
 * @Expected result ：
 */
public class ThreeadWrite extends Thread{
    private WriteData writeData;
    private PipedOutputStream outputStream;
    public ThreeadWrite(WriteData writeData, PipedOutputStream outputStream) {
        this.writeData = writeData;
        this.outputStream = outputStream;
    }
    @Override
    public void run() {
        writeData.writeMethod(outputStream);
    }
}
