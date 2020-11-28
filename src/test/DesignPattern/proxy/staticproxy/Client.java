package DesignPattern.proxy.staticproxy;

public class Client {
    public static void main(String[] args) {
        //创建目标对象
        TeacherDao teacherDao=new TeacherDao();

        //创建代理对象，同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy=new TeacherDaoProxy(teacherDao);

        //通过调用代理对象的方法，间接调用被代理对象(目标对象)的实际方法
        teacherDaoProxy.teach();
    }
}
