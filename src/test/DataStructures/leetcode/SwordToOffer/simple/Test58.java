package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/06/07/23:49
 * @Description :
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @Page or WebSite：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * @Expected result ：
 */
public class Test58 {
    //切割字串并重新组合
    public String reverseLeftWords(String s, int n) {
        String substring1 = s.substring(0, 2);
        String substring2 = s.substring(2);
        return substring2 + substring1;
    }
    public String reverseLeftWords1(String s, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        /**
         * 使用求余的方式，可以简化代码
         *StringBuilder res = new StringBuilder();
         *for(int i = n; i < n + s.length(); i++)
         *    res.append(s.charAt(i % s.length()));
         *return res.toString();
         */
        return sb.toString();
    }
}
