package DesignPattern.memento.theory;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    // ��list���кܶԵı���¼����
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
