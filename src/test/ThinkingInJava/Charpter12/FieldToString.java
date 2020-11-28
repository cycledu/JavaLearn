package ThinkingInJava.Charpter12;

/**
 * @Author : jingtao
 * @Data : 2020/04/04/16:19
 * @Description :
 * @Page or WebSite：295
 * @Expected result ：
 */
public class FieldToString {
    private int a;
    private long b;
    private float c;
    private double d;

    @Override
    public String toString() {
        return "FieldToString{" +
                "a=" + String.format("%5d",a) +
                ", b=" +  String.format("%2d",b) +
                ", c=" +  String.format("%2f",c)+
                ", d=" +  String.format("%20f",d)+
                '}';
    }
   public FieldToString(int a, long b, float c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public static void main(String[] args) {
        FieldToString fieldToString = new FieldToString(10,20,30,40);
        System.out.println(fieldToString);
    }


}
