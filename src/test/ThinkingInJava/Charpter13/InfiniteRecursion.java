package ThinkingInJava.Charpter13;

import java.util.ArrayList;

/**
 * @Author : jingtao
 * @Data : 2020/04/03/23:42
 * @Description :
 * @Page or WebSite：287
 * @Expected result ：
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
//         return "InfiniteRecursion address : " + this + "\n";  //会发生异常
       return super.toString();
    }

    public static void main(String[] args) {
        ArrayList<InfiniteRecursion> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            objects.add(new InfiniteRecursion());
        objects.toString();

        System.out.println(objects);
    }

}
