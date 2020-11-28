package ThinkingInJava.Charpter11.Test.practise16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/15:55
 * @Description :
 * @Page or WebSite：P233/练习16
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) throws IOException {
        File file = new File("G:/Springboot/ThinkingInJava/src/Charpter11/Test/practise15/Run.java");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = bufferedReader.readLine()) != null) {
            sb.append(s + "\n");
        }
        bufferedReader.close();
        String string = sb.toString();
        System.out.println(string);
        String[] split = string.split("\\s");
        String aeiou = "aeiou";
        int num = 0;
        for (String a : split) {
            String[] split1 = a.split("");
            for (int i = 0; i < split1.length; i++) {
                String s1 = split[i].toLowerCase();
                if (aeiou.contains(s1)) {
                    num++;
                }
            }

        }
        System.out.println(num);
    }
}
