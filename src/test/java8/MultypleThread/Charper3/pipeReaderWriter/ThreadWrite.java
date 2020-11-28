package java8.MultypleThread.Charper3.pipeReaderWriter;

import java.io.PipedWriter;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/15:05
 * @Description :
 * @Page or WebSite：P254
 * @Expected result ：
 */
public class ThreadWrite extends Thread {
    private WriteData writeData;
    private PipedWriter pipedWriter;
    public ThreadWrite(WriteData writeData, PipedWriter pipedWriter) {
        this.writeData = writeData;
        this.pipedWriter = pipedWriter;
    }
    @Override
    public void run() {
        writeData.writeMethod(pipedWriter);
    }
}
