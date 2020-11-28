package ThinkingInJava.Charpter14;

/**
 * @Author : jingtao
 * @Data : 2020/04/07/23:19
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
class Building{};
class House extends Building{};
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h= (House) b;
        System.out.println(h.getClass());
    }
}
