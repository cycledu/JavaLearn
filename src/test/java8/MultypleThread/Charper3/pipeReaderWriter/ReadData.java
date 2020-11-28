package java8.MultypleThread.Charper3.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/15:02
 * @Description :
 * @Page or WebSite：P254
 * @Expected result ：
 */
public class ReadData {
    public void readMethod(PipedReader input) {
        try {
            System.out.println("read:");
            char[] byteArray = new char[20];
            int readlength = input.read(byteArray);
            while (readlength != -1) {
                String newData = new String(byteArray, 0, readlength);
                System.out.print(newData);
                readlength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
