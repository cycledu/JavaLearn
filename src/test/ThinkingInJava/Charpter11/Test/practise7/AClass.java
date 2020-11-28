package ThinkingInJava.Charpter11.Test.practise7;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/14:41
 * @Description :
 * @Page or WebSite：P226/练习7
 * @Expected result ：
 */
public class AClass {
    private int number;
    public AClass(int number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "AClass:"+number;
    }
}
