package ThinkingInJava.Charpter11.Test.practise15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Run {
    public static void main(String[] args) {
        String a="+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u---+l+e+s---";
        List<String> strings1 = new ArrayList<String>();
        for (int i = 0; i < a.length(); i++) {
            strings1.add(a.substring(i,i+1));
        }
        Stack<String> strings = new Stack<>();
        Iterator<String> iterator = strings1.iterator();
        if (iterator.hasNext()){
            if (iterator.next().equals("+")){
                iterator.next();
                strings.push(iterator.next());
            }else if (iterator.next().equals("-")){
                iterator.next();
                System.out.println(strings.pop());
            }
        }
        System.out.println(strings);
    }
}
