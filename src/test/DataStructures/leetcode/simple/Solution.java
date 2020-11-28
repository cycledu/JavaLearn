package DataStructures.leetcode.simple;

/**
 * @Author : jingtao
 * @Data : 2020/05/19/22:11
 * @Description :
 * @Page or WebSite£º
 * @Expected result £º
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;

        String low = s.toLowerCase();

        int i = 0;
        int j = low.length() - 1;

        while (i < j) {
            while (!Character.isLetterOrDigit(low.charAt(i))) {
                i++;
            }
            while (!Character.isLetterOrDigit(low.charAt(j))) {
                j--;
            }
            if (low.charAt(i) != low.charAt(j))
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}
