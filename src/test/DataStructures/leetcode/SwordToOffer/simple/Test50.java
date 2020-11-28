package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/06/01/20:53
 * @Description :
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 * @Page or WebSite：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @Expected result ：
 */
/*
 *遍历数组
 * 将数组元素放入map, 键-元素：值-出现次数
 * 遍历map，得到第一个值为1的元素
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 解法：ASCII码一共256个字符
 * 创建长度为256的int数组
 * 第一次遍历将对应位置上的值加1
 * 第二次遍历如果对应位置上的值为1，则这个位置上的字符就是第一个只出现过一次的字符
 */
public class Test50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char  c : s.toCharArray()) {
             if (map.containsKey(c))
                 map.put(c,map.get(c)+1);
             else
                 map.put(c,1);
        }
        Set<Character> strings = map.keySet();
        for (Character aa : strings) {
            if (map.get(aa).equals(1)){
                return aa;
            }
        }
        return ' ';
    }
    /**
     * //判断存在状态，如果存在就置入false，最后只有一个字符的为true
     *      使用字符串中的字符为键查看第一个为ture的键
     *     public char firstUniqChar(String s) {
     *         HashMap<Character, Boolean> dic = new HashMap<>();
     *         char[] sc = s.toCharArray();
     *         for(char c : sc)
     *             dic.put(c, !dic.containsKey(c));
     *         for(char c : sc)
     *             if(dic.get(c)) return c;
     *         return ' ';
     *     }
     */


    public char firstUniqChar1(String s) {
        int[] ints = new int[256];
        char[] chars = s.toCharArray();
        for (char c:chars){
            ints[c]++;
        }
        for (char c:chars){
            if (ints[c]==1){
                return c;
            }
        }
        return ' ';
    }
}
