package java8.IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author : jingtao
 * @Data : 2020/10/17/20:15
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class Test {
    @org.junit.Test
    public void test() throws FileNotFoundException {
        String path="C:\\Users\\jingtao\\Documents";
        File file = new File(path);
        for (File listFile : file.listFiles()) {
            System.out.println(listFile.getName()+":"+(double)listFile.length());
        }
    }
}
