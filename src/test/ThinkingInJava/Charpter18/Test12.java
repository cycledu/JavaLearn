package ThinkingInJava.Charpter18;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/07/08/23:18
 * @Description :
 * @Page or WebSite：P543
 * @Expected result ：
 */
public class Test12 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("E:\\2020-01-23.txt"));
        List<String> linkedList = new LinkedList<>();
        String s;
        while ((s = in.readLine()) != null) {
            linkedList.add(s);
        }
        FileWriter fileWriter = new FileWriter("E:\\2019-04-08.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        Iterator<String> iterator = linkedList.iterator();
        int line = 0;
        while (iterator.hasNext()) {
            printWriter.println(++line + ":" + iterator.next());
        }
        printWriter.flush();
    }
}
