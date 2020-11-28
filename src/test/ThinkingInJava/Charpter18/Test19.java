package ThinkingInJava.Charpter18;

import ThinkingInJava.Charpter18.util.Directory;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author : jingtao
 * @Data : 2020/07/09/23:13
 * @Description :P548
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test19 {
    public static void main(String[] args) throws IOException {
        byte[] read = read(new File("E:\\2020-01-23.txt"));
        Map<Byte, Integer> map = new HashMap<>();
        for (int i = 0; i < read.length; i++) {
            byte b = read[i];
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        System.out.println(map);
    }
    public static byte[] read(File name) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(name));
        byte[] data = null;
        try {
            data = new byte[bf.available()];
            bf.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bf.close();
        }
        return data;
    }

    @Test
    public void test20() throws IOException {
        Directory.TreeInfo walk = Directory.walk("G:\\Springboot\\ThinkingInJava\\out\\production\\ThinkingInJava" +
                "\\Charpter16", ".*");
        Iterator<File> iterator = walk.iterator();
        while (iterator.hasNext()) {
            File next = iterator.next();
            byte[] read = read(next);
//            String s = Integer.toHexString(read[0]& 0xFF) + Integer.toHexString(read[1]& 0xFF);
            String s =
                    String.format("%02x", read[0]) + String.format("%02x", read[1])+ String.format("%02x", read[2])+ String.format("%02x", read[3]);
            System.out.println(next+":"+s.equals("CAFEBABE")+":"+s);
        }
    }
}
