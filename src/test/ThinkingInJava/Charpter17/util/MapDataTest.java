package ThinkingInJava.Charpter17.util;//: containers/MapDataTest.java


import ThinkingInJava.Charpter15.Generator;
import ThinkingInJava.Charpter16.CountingGenerator;
import ThinkingInJava.Charpter17.RandomGenerator;

import java.util.*;


/**
 * 463
 */
class Letters implements Generator<Pair<Integer, String>>,
        Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public Integer next() {
                return number++;
            }
            public boolean hasNext() {
                return number < size;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        // Pair Generator:
        System.out.println("使用泛型的生成器和规定长度，生成容器");
        System.out.println(MapData.map(new Letters(), 11));
        // Two separate generators:
        System.out.println("使用泛型K、V的生成器和规定长度，生成容器");
        //生成长度为3的随机字符串（RandomGenerator.String继承过生成器，有next方法）
        System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));
        // A key Generator and a single value:
        System.out.println("使用K的生成器，和规定长度，放入同样的V");
        System.out.println(MapData.map(new CountingGenerator.Character(), "Value", 6));
        // An Iterable and a value Generator:
        System.out.println("使用K的迭代器和V的生成器制造容器");
        //迭代器设置的长度不超过9，所以迭代出8个值
        System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
        // An Iterable and a single value:
        System.out.println("迭代所有K，放入相同的V");
        //迭代出8个值，全都放“Pop”
        System.out.println(MapData.map(new Letters(), "Pop"));
    }
} /* Output:
{1=A, 2=B, 3=C, 4=D, 5=E, 6=F, 7=G, 8=H, 9=I, 10=J, 11=K}
{a=YNz, b=brn, c=yGc, d=FOW, e=ZnT, f=cQr, g=Gse, h=GZM}
{a=Value, b=Value, c=Value, d=Value, e=Value, f=Value}
{1=mJM, 2=RoE, 3=suE, 4=cUO, 5=neO, 6=EdL, 7=smw, 8=HLG}
{1=Pop, 2=Pop, 3=Pop, 4=Pop, 5=Pop, 6=Pop, 7=Pop, 8=Pop}
*///:~
