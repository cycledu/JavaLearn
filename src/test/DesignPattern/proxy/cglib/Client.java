package DesignPattern.proxy.cglib;

public class Client {
    public static void main(String[] args) {
        //����Ŀ�����
        TeacherDao teacherDao = new TeacherDao();
        //��ȡ������󣬲��ҽ�Ŀ����󴫵ݸ��������
        TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(teacherDao).getProxyInstance();
        //ִ�д������ķ���������intecepter�������Ӷ�ʵ�ֶ�Ŀ�����ĵ���
        proxyInstance.teach();
    }
}
