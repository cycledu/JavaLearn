package ThinkingInJava.Charpter10;//: innerclasses/Sequence.java
// Holds a sequence of Objects.

interface Selector {
  boolean end();
  Object current();
  void next();
}

public class Sequence {
  private Object[] items;
  private int next = 0;
  public Sequence(int size) { items = new Object[size]; }
  public void add(Object x) {
    if(next < items.length)
      items[next++] = x;
  }
  private class SequenceSelector implements Selector {
    private int i = 0;
    public boolean end() { return i == items.length; }
    public Object current() { return items[i]; }
    public void next() { if(i < items.length) i++; }
    //P194/练习4：返回外部类的引用
    public Sequence returnSequence(){
      return Sequence.this;
    }
  }
  public Selector selector() {
    return new SequenceSelector();
  }
  public static void main(String[] args) {
    Sequence sequence = new Sequence(10);
    for(int i = 0; i < 10; i++) {
    //练习2：P92
      OuterTest192 outerTest192 = new OuterTest192("第" + (i + 1) + "个对象");
      sequence.add(outerTest192);
    }
      Selector selector = sequence.selector();
      SequenceSelector selector1 = (SequenceSelector) sequence.selector();
      Sequence sequence1 = selector1.returnSequence();
      System.out.println("这里验证P194/练习4：返回外部类的引用是否生效");
      System.out.println(sequence1.items[2]);
      System.out.println("======================================================");
      while(!selector.end()) {
      System.out.println(selector.current() + " ");
      selector.next();
    }
  }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~
