package ThinkingInJava.Charpter17.practise2;


import ThinkingInJava.Charpter17.util.Countries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : jingtao
 * @Data : 2020/05/15/22:59
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < Countries.DATA.length; i++) {
            if (Countries.DATA[i][0].startsWith("A")) {
                set.add(Countries.DATA[i][0]);
                map.put(Countries.DATA[i][0],Countries.DATA[i][1]);
            }
        }
        System.out.println(map);
        System.out.println(set);
    }
}
