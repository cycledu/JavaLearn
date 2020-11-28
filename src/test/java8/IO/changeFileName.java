package java8.IO;

import java.io.File;

/**
 * @Author : jingtao
 * @Data : 2020/07/04/16:37
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class changeFileName {
    public static void main(String[] args) {
        File file = new File("E:\\下载工具\\Download\\JavaNIO");
        for (File listFile : file.listFiles()) {
            listFile.renameTo(new File("E:\\下载工具\\Download\\JavaNIO\\"+listFile.getName().substring(19)));
        }
    }
}
