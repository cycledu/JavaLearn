package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/11/07/22:07
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class Test20 {
    public boolean isNumber(String s) {
        if (s == null || s.equals("")) {
            return false;
        } else {
            if ((int) s.charAt(0) < 48 || (int) s.charAt(s.length() - 1) > 59) {
                return false;
            } else {

            }
        }
        return false;
    }
}
