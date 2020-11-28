package java8.Test;

/**
 * @Author : jingtao
 * @Data : 2020/11/08/22:19
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class testIfAndSwitch {
    public static void main(String[] args) {

        String a = "1";

        methodUseIf(a);
        methodUseSwitch(a);
    }

    private static void methodUseSwitch(String a) {
        switch (a) {
            case ("1"):
                System.out.println(1);
                break;
            case ("2"):
                System.out.println(2);
                break;
            case ("3"):
                System.out.println(3);
                break;
            case ("4"):
                System.out.println(4);
                break;
            case ("5"):
                System.out.println(5);
                break;
            default:
                System.out.println(6);
        }
    }

    private static void methodUseIf(String a) {
        if (a.equals("1"))
            System.out.println(1);
        else if (a.equals("2"))
            System.out.println(2);
        else if (a.equals("3"))
            System.out.println(3);
        else if (a.equals("4"))
            System.out.println(4);
        else if (a.equals("5"))
            System.out.println(5);
        else System.out.println(6);
    }
}
