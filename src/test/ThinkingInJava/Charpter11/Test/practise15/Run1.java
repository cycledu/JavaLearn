package ThinkingInJava.Charpter11.Test.practise15;

import java.util.Stack;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/15:32
 * @Description :
 * @Page or WebSite：P231/练习15
 * @Expected result ：
 */
public class Run1 {
    public static void main(String[] args) {
        String a="+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        String[]aa=a.split("");
        Stack<String> strings = new Stack<>();
        for (int i = 0; i < aa.length; i++) {
            if (aa[i].equals("+")){
                strings.push(aa[i+1]);
            }else if (aa[i].equals("-")){
                System.out.print(strings.pop());
            }
        }
    }
}
