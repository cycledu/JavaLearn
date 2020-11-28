package DataStructures.leetcode.SwordToOffer.simple;

/**
 * @Author : jingtao
 * @Data : 2020/06/21/23:06
 * @Description :写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @Page or WebSite：
 * @Expected result ：
 */
//https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/er-jin-zhi-qiu-he-chao-xiang-xi-da-bai-10000yong-h/
public class Test65 {
    public static void main(String[] args) {

    }
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位  得出a+b中的所有进位为1的结果
            a ^= b; // a = 非进位和     a和b异或运算后无进位赋值给a
            b = c; // b = 进位
        }
        return a;
    }
}
