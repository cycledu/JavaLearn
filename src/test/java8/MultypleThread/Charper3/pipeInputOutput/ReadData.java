package java8.MultypleThread.Charper3.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/14:35
 * @Description :
 * @Page or WebSite：P251
 * @Expected result ：
 */
public class ReadData {
    public void readMethod(PipedInputStream inputStream) {
        try {
            System.out.println("read:");
            byte[] byteArray = new byte[20];
            int readline = inputStream.read(byteArray);
            while (readline != -1) {
                String newData = new String(byteArray, 0, readline);
                System.out.print(newData);
                readline = inputStream.read(byteArray);
            }
            System.out.println();
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
