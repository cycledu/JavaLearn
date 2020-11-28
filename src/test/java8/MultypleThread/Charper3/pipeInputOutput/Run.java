package java8.MultypleThread.Charper3.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/14:46
 * @Description :
 * @Page or WebSite：P252
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            pipedInputStream.connect(pipedOutputStream);
            //pipedOutputStream.connect(pipedInputStream);
            ThreadRead threadRead = new ThreadRead(readData, pipedInputStream);
            threadRead.start();
            Thread.sleep(2000);
            ThreeadWrite threeadWrite = new ThreeadWrite(writeData, pipedOutputStream);
            threeadWrite.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
