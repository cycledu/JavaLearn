package DataStructures.leetcode.SwordToOffer.simple;

import java.util.Arrays;

/**
 * @Author : jingtao
 * @Data : 2020/05/24/15:00
 * @Description :
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * @Page or WebSite：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @Expected result ：
 */
public class Test17 {
    //将参数转换为n位数加1的值，遍历给数组填值
    public int[] printNumbers(int n) {
        int i = Integer.parseInt(Integer.toBinaryString(1 << n));
        int[] ints = new int[i - 1];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = j + 1;
        }
        return ints;
    }
    //使用jdk的幂函数
    public int[] printNumbers1(int n) {
        int num = (int)Math.pow(10,n);
        int[] arr = new int[num - 1];
        for(int i = 0 ; i < arr.length;i++){
            arr[i] += i+1;
        }
        return arr;
    }
    //快速幂方法
    public int fast_pow(int base,int index){
        int ans = 1;
        while(index>0){
            //当指数为奇数时，ans与基数相乘
            if(index%2==1){
                ans*=base;
            }
            index/=2;
            base*=base;
        }
        return ans;
    }
    public int[] printNumbers2(int n) {
        int sz = fast_pow(10,n)-1;
        int[] ans = new int[sz];
        for(int i=0;i<sz;++i){
            ans[i] = i+1;
        }
        return ans;
    }
    //大数问题
    public class solution {
        public void printNumbers(int n) {
            StringBuilder str = new StringBuilder();
            // 将str初始化为n个'0'字符组成的字符串
            for (int i = 0; i < n; i++) {
                str.append('0');
            }
            while(!increment(str)){
                // 去掉左侧的0
                int index = 0;
                while (index < str.length() && str.charAt(index) == '0'){
                    index++;
                }
                System.out.println(str.toString().substring(index));
            }
        }

        public boolean increment(StringBuilder str) {
            boolean isOverflow = false;
            for (int i = str.length() - 1; i >= 0; i--) {
                char s = (char)(str.charAt(i) + 1);
                // 如果s大于'9'则发生进位
                if (s > '9') {
                    str.replace(i, i + 1, "0");
                    if (i == 0) {
                        isOverflow = true;
                    }
                }
                // 没发生进位则跳出for循环
                else {
                    str.replace(i, i + 1, String.valueOf(s));
                    break;
                }
            }
            return isOverflow;
        }
    }
    public static void main(String[] args) {
        Test17 test17 = new Test17();
        System.out.println(Arrays.toString(test17.printNumbers2(5)));
    }
}
