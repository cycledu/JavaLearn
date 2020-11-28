package java8.Regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author : jingtao
 * @Data : 2020/07/04/23:21
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class testRegex {

    @Test
    public void test1(){
        //表达式对象
        Pattern compile = Pattern.compile("\\w+");
        //匹配对象
        Matcher matcher = compile.matcher("asdsadsad2232");
        boolean matches = matcher.matches();// 尝试将整个字符序列与该模式匹配
        System.out.println(matches);
    }

    @Test
    public void test2(){
        //表达式对象
        Pattern compile = Pattern.compile("\\w+");
        //匹配对象
        Matcher matcher = compile.matcher("asdsadsad2232#￥#%");
        boolean b1 = matcher.find();//扫描输入的序列，查找与该模式匹配的下一个子序列
        System.out.println(matcher.group());//返回找到的内容
        boolean b2 = matcher.find();//扫描输入的序列，查找与该模式匹配的下一个子序列
        System.out.println(b1);//只有一个匹配的子序列：asdsadsad2232
        System.out.println(b2);
    }
}
