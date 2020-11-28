package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/05/22/22:50
 * @Description :
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @Page or WebSite：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @Expected result ：
 */
public class Test05 {
    //2ms
    public String replaceSpace(String s) {
        s=s.replaceAll(" ","%20");
        return s;
    }
    //多个空格连接的字符串无法使用
    public String replaceSpace1(String s) {
        String[] s1 = s.split(" ");//多个空格会一起分割掉
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            sb.append(s1[i]);
            if (i==s1.length-1){
                break;
            }
            sb.append("%20");
        }
        return sb.toString();
    }

    //遍历字符串的每一个字符，如果是空格，就append（"%20"），否则append(原字符)
    public String replaceSpace2(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Test05 test05 = new Test05();
        System.out.println(test05.replaceSpace2("We are happy."));
    }
}
