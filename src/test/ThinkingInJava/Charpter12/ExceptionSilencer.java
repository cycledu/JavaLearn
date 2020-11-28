package ThinkingInJava.Charpter12;

/**
 * @Author : jingtao
 * @Data : 2020/04/01/23:59
 * @Description :异常丢失的第二种情况
 * @Page or WebSite：269
 * @Expected result ：
 */
public class ExceptionSilencer {
    public static void main(String[] args) {
        try{
            throw new RuntimeException();
        }finally {
            return;
        }
    }
}
