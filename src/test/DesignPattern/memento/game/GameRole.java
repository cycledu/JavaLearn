package DesignPattern.memento.game;

public class GameRole {
    // 攻击力
    private int vit;
    // 防御力
    private int def;

    // 创建Memento，即根据当前状态创建Memento
    public Memento createMemento() {
        return new Memento(vit, def);
    }

    // 从备忘录对象恢复GameRole的状态
    public void recoverGameRoleFromMemento(Memento memento) {
        this.vit = memento.getVit();
        this.vit = memento.getDef();
    }

    // 显示当前游戏角色的状态
    public void display() {
        System.out.println("游戏角色当前攻击力：" + this.vit + "，防御力：" + this.def);
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

}
