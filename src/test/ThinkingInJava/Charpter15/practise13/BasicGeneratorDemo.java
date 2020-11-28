package ThinkingInJava.Charpter15.practise13;//: generics/BasicGeneratorDemo.java

import ThinkingInJava.Charpter15.BasicGenerator;

/**
 * P365/练习14
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        BasicGenerator<CountedObject> gen = new BasicGenerator<>(CountedObject.class);
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
} /* Output:
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
*///:~
