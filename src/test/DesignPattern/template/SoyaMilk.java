package DesignPattern.template;

public abstract class SoyaMilk {
    // ģ�巽������������Ϊfinal����ֹ���า��
    final void make() {
        select();
        addCondiments();
        soak();
        beat();
    }

    // ѡ����
    void select() {
        System.out.println("1:ѡ�����ʻƶ�");
    }

    // ��Ӳ�ͬ�����ϣ����󷽷����������ʵ��
    abstract void addCondiments();

    void soak() {
        System.out.println("2:���Ͽ�ʼ����");
    }

    void beat() {
        System.out.println("4:��������");
    }

}
