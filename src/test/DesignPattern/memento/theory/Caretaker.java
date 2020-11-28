package DesignPattern.memento.theory;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    // 在list中有很对的备忘录对象
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
