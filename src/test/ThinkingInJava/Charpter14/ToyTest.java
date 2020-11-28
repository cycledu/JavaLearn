package ThinkingInJava.Charpter14;
/**
 * @Author : jingtao
 * @Data : 2020/04/06/21:59
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
//: typeinfo/toys/ToyTest.java
// Testing class Class.

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    Toy() {}//注释掉默认构造器，50行的newInstance无法执行
    Toy(int i) {}
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1); }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("Charpter14.FancyToy");
        } catch(ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch(InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch(IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
} /* Output:
Class name: Charpter14.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : Charpter14.FancyToy
Class name: Charpter14.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : Charpter14.HasBatteries
Class name: Charpter14.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : Charpter14.Waterproof
Class name: Charpter14.Shoots is interface? [true]
Simple name: Shoots
Canonical name : Charpter14.Shoots
Class name: Charpter14.Toy is interface? [false]
Simple name: Toy
Canonical name : Charpter14.Toy
*///:~
