package DesignPattern.factory;

public abstract class Pizza {
    protected String name;

    public Pizza(String name) {
        this.name = name;
    }

    //׼��ԭ���ϣ���ͬ��������һ����������ɳ��󷽷�
    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        prepare();
        bake();
        cut();
        bake();
        return "";
    }
}

