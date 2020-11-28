package java8.MultypleThread.Charper3.pipeInputOutput;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/14:30
 * @Description :
 * @Page or WebSite：P251
 * @Expected result ：
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out){
        try{
            System.out.println("write:");
            for (int i = 0; i < 300; i++) {
                String outData=""+(i+1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
