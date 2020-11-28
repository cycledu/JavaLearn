package java8.MultypleThread.Charper3.pipeReaderWriter;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/15:08
 * @Description :
 * @Page or WebSite：P255
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        try{
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedReader pipedReader = new PipedReader();
            PipedWriter pipedWriter = new PipedWriter();
            pipedWriter.connect(pipedReader);
            ThreadRead threadRead = new ThreadRead(readData, pipedReader);
            threadRead.start();
            Thread.sleep(2000);
            ThreadWrite threadWrite = new ThreadWrite(writeData, pipedWriter);
            threadWrite.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
