package ThinkingInJava.Charpter17.containers;//: containers/Test.java
// Framework for performing timed tests of containers.

public abstract class Test<C> {
    String name;
    public Test(String name) {
        this.name = name;
    }
    // Override this method for different tests.
    // Returns actual number of repetitions of toolTest.
    abstract int test(C container, TestParam tp);
} ///:~
