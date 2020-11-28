package ThinkingInJava.Charpter17.practise7;

import ThinkingInJava.Charpter17.util.Countries;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/05/15/23:35
 * @Description :
 * @Page or WebSite：P477
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Countries.names(5));
        List<String> linkedList = new LinkedList<>(Countries.names(5));
        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining(s -> System.out.print(s + ","));

        System.out.println();

        Iterator<String> iterator1 = linkedList.iterator();
        iterator1.forEachRemaining(s -> System.out.print(s + ","));
        System.out.println();
        ListIterator<String> stringListIterator = list.listIterator(list.size());
        ListIterator<String> stringListIterator1 = linkedList.listIterator();
        //从list的末尾开始，将linkedlist的值顺序间隔插入
        while (stringListIterator.hasPrevious()) {
            if (stringListIterator1.hasNext()) {
                stringListIterator.add(stringListIterator1.next());
                stringListIterator.previous();
                //再次向前一位是因为每当在lsit中加入一个新元素，stringListIterator的index还在原来的位置，而index前面的元素多了一个
                stringListIterator.previous();
            }
            if (stringListIterator1.nextIndex()==5)
                break;
        }
        System.out.println();
        System.out.println(list);
    }
}
