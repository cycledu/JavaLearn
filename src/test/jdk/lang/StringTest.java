package jdk.lang;

import org.junit.Test;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/18:29
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class StringTest {

    @Test
    public void StringTest1(){
        char[] chars = new char[5];
        for (int i = 0; i < chars.length; i++) {
            chars[i]=(char)(i+55);
        }
        String a=new String(chars,0,chars.length);
        System.out.println(a);
    }
}
