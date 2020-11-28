package DesignPattern.memento.theory;

public class Orginator {
    private String state;// ״��Ϣ

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // ��дһ�����������Ա���һ��״̬����Memento
    public Memento saveStateMemento() {
        return new Memento(state);
    }

    // ͨ������¼����ָ�״̬
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
