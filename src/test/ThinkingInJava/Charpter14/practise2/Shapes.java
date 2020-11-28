package ThinkingInJava.Charpter14.practise2;//: typeinfo/Shapes.java

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }
    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {
    @Override
    public String toString() {
        return "Rhomboid";
    }
}
public class Shapes { //练习5
    public static void rotate(Shape shape) {
     if (shape instanceof Circle)
         System.out.println("是 Circle，旋转");
     else
         System.out.println("不是Circle，不能旋转");
    }

    public static void main(String[] args) {
        Shape rhomboid = (Shape) new Rhomboid();
        System.out.println(rhomboid.toString());
        if (rhomboid instanceof Circle)//练习3
            System.out.println(((Circle) rhomboid).toString());
        rotate(rhomboid);
    }
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~
