package DesignPattern.memento.game;

public class Client {
    public static void main(String[] args) {
        // ������Ϸ��ɫ
        GameRole gameRole = new GameRole();
        // �����ʼ������ֵ
        gameRole.setVit(100);
        gameRole.setDef(100);

        System.out.println("��ʼ��״̬");
        gameRole.display();

        // ����ǰ״̬���浽caretaker
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("״̬�޸�");
        gameRole.setDef(30);
        gameRole.setVit(30);

        gameRole.display();

        System.out.println("�ָ�״̬��");
        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        gameRole.display();
    }
}
