package DesignPattern.proxy.dynamic;

public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("��ʦ�ڿ��С���������");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
