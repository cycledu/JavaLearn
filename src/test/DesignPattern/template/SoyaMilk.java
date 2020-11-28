package DesignPattern.template;

public abstract class SoyaMilk {
    // 模板方法，可以设置为final，防止子类覆盖
    final void make() {
        select();
        addCondiments();
        soak();
        beat();
    }

    // 选材料
    void select() {
        System.out.println("1:选择新鲜黄豆");
    }

    // 添加不同的配料，抽象方法，子类具体实现
    abstract void addCondiments();

    void soak() {
        System.out.println("2:材料开始浸泡");
    }

    void beat() {
        System.out.println("4:制作豆浆");
    }

}
