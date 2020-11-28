package ThinkingInJava.Charpter11;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : jingtao
 * @Data : 2020/04/01/0:05
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class test {
    public static void main(String[] args) {
        Map<String, String> linkedHashMap = new HashMap<>(10);
        linkedHashMap.put("1","1");
        linkedHashMap.put("2","1");
        linkedHashMap.put("3","1");
        linkedHashMap.put("5","1");
        linkedHashMap.put("7","1");
        linkedHashMap.put("8","1");
        linkedHashMap.put("4","1");
//        linkedHashMap.putIfAbsent("9","2");
        System.out.println(linkedHashMap.toString());
    }
}
