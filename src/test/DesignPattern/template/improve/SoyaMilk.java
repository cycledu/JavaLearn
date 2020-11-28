package DesignPattern.template.improve;

public abstract class SoyaMilk {
    // ģ�巽������������Ϊfinal����ֹ���า��
    final void make() {
        select();
        if (customerWantCondiments()) {
            addCondiments();
        }
        soak();
        beat();
    }

    // ѡ����
    void select() {
        System.out.println("1:ѡ���»ƶ�");
    }

    // ��Ӳ�ͬ�����ϣ����󷽷����������ʵ��
    boolean customerWantCondiments() {
        return true;
    }

    // ���ӷ����������Ƿ���Ҫ�������
    abstract void addCondiments();

    void soak() {
        System.out.println("2:���Ͽ�ʼ����");
    }

    void beat() {
        System.out.println("4:��������");
    }
}
