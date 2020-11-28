package DesignPattern.memento.theory;

public class Client {

    public static void main(String[] args) {
        Orginator orginator = new Orginator();
        Caretaker caretaker = new Caretaker();
        orginator.setState("状态1");
        
        //保存一个状态
        caretaker.add(orginator.saveStateMemento());
        
        System.out.println("当前状态："+orginator.getState());
    }

}
