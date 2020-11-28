package ThinkingInJava.Charpter17.practise3;


import ThinkingInJava.Charpter17.util.Countries;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/05/15/22:59
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        for (int i = 0; i < Countries.DATA.length; i++) {
            if (Countries.DATA[i][0].startsWith("A")) {
                set.add(Countries.DATA[i][0]);//按哈希值根据某种规则进行排序
               // set.add(Countries.DATA[i][0]);
                linkedHashSet.add(Countries.DATA[i][0]);//按存入顺序放置元素
               // linkedHashSet.add(Countries.DATA[i][0]);
                treeSet.add(Countries.DATA[i][0]);//字典序
                treeSet.add(Countries.DATA[i][0]);
            }
        }
        set.forEach((s -> System.out.print(s.hashCode()+ " ")));
        System.out.println();
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
    }
}
