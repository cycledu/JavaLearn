package DesignPattern.memento.game;

public class Client {
    public static void main(String[] args) {
        // 创建游戏角色
        GameRole gameRole = new GameRole();
        // 赋予初始的属性值
        gameRole.setVit(100);
        gameRole.setDef(100);

        System.out.println("初始的状态");
        gameRole.display();

        // 将当前状态保存到caretaker
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        System.out.println("状态修改");
        gameRole.setDef(30);
        gameRole.setVit(30);

        gameRole.display();

        System.out.println("恢复状态后");
        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
        gameRole.display();
    }
}
