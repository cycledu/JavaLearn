package java8.MultypleThread.Charper3.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/14:57
 * @Description :
 * @Page or WebSite：P253
 * @Expected result ：
 */
public class WriteData {
    public void writeMethod(PipedWriter out){
        try {
            System.out.println("write:");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData);
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
