package DesignPattern.proxy.staticproxy;

// 代理对象
public class TeacherDaoProxy implements ITeacherDao {
    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理");
        target.teach();
        System.out.println("结束代理");
    }

}
