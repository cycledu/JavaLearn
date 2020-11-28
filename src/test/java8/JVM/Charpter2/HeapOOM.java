package java8.JVM.Charpter2;

import java.util.ArrayList;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/15:47
 * @Description :    -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @Page or WebSite：2-3
 * @Expected result ：
 *
 * java.lang.OutOfMemoryError: Java heap space
 * Dumping heap to java_pid5360.hprof ...
 * Heap dump file created [28247863 bytes in 0.184 secs]
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at java.util.Arrays.copyOf(Arrays.java:3210)
 */
public class HeapOOM {
    static class OOMObject{

    }
    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
