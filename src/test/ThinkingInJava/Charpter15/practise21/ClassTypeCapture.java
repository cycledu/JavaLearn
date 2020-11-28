package ThinkingInJava.Charpter15.practise21;//: generics/ClassTypeCapture.java

import java.util.Map;

//P381/练习15
class Building {
}
class House extends Building {
}

public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String,Class<?>> map;
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
    public void addType(String typename,Class<?>kind){
        map.put(typename,kind);
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 =
                new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 =
                new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
} /* Output:
true
true
false
true
*///:~
