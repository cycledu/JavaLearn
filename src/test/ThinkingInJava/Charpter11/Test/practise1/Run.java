package ThinkingInJava.Charpter11.Test.practise1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/14:11
 * @Description :
 * @Page or WebSite：P218/练习1
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        List<Gerbil> list = new ArrayList<Gerbil>();
        for (int i = 0; i < 5; i++) {
            Gerbil gerbil = new Gerbil(i);
            list.add(gerbil);
        }
        for (Gerbil g : list) {
            g.hop();
        }
    }
}
