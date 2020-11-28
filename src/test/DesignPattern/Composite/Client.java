package DesignPattern.Composite;

public class Client {
public static void main(String[] args) {
	//����ѧУ
	OrganizationComponent university=new University("�廪��ѧ", "�廪��ѧ������");
	
	//����ѧԺ
	OrganizationComponent infomation=new College("��ϢѧԺ", "��ϢѧԺ������");
	OrganizationComponent computer=new College("�����ѧԺ", "�����ѧԺ������");
	
	//��������ѧԺ�����רҵ
	infomation.add(new Department("��Ϣ����", "��Ϣ���̵�����"));
	infomation.add(new Department("ͨ��", "ͨ��רҵ������"));
	
	computer.add(new Department("�ƿ�", "�ƿ�����"));
	computer.add(new Department("�������", "���רҵ����"));
	
	//��ѧԺ�ӵ�ѧУ
	university.add(computer);
	university.add(infomation);
	
	//ֱ�Ӵ�ӡѧУ��ѧԺ
	university.print();
}
}
