package ThinkingInJava.Charpter18.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Author : jingtao
 * @Data : 2020/04/20/23:03
 * @Description :   527
 * @Page or WebSite：
 * @Expected result ：
 */
public class DirList3 {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
//        if (args.length==0)
//            list=path.list();
//        else
        list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile("^\\w+\\W.+");
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
