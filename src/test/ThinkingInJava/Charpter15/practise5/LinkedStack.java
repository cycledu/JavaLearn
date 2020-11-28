package ThinkingInJava.Charpter15.practise5;//: generics/LinkedStack.java
// A stack implemented with an internal linked structure.

//修改点：将静态内部类改为不同类
//         将Node的泛型去掉，单独的U使用T替换（以此证明内部类可以访问外部类的参数类型：即外部类的参数类型可以传到内部类之中）
public class LinkedStack<T> {
    private  class Node {
        T item;
        Node next;
        Node() {
            item = null;
            next = null;
        }
        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return item == null && next == null;
        }
    }
    private Node top = new Node(); // End sentinel
    public void push(T item) {
        top = new Node(item, top);
    }
    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }
    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        for (String s : "Phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while ((s = lss.pop()) != null)
            System.out.println(s);
    }
} /* Output:
stun!
on
Phasers
*///:~
