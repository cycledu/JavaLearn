package DesignPattern.memento.theory;

public class Client {

    public static void main(String[] args) {
        Orginator orginator = new Orginator();
        Caretaker caretaker = new Caretaker();
        orginator.setState("״̬1");
        
        //����һ��״̬
        caretaker.add(orginator.saveStateMemento());
        
        System.out.println("��ǰ״̬��"+orginator.getState());
    }

}
