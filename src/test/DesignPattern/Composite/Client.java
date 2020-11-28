package DesignPattern.Composite;

public class Client {
public static void main(String[] args) {
	//创建学校
	OrganizationComponent university=new University("清华大学", "清华大学的描述");
	
	//创建学院
	OrganizationComponent infomation=new College("信息学院", "信息学院的描述");
	OrganizationComponent computer=new College("计算机学院", "计算机学院的描述");
	
	//创建各个学院下面的专业
	infomation.add(new Department("信息工程", "信息工程的描述"));
	infomation.add(new Department("通信", "通信专业的描述"));
	
	computer.add(new Department("计科", "计科描述"));
	computer.add(new Department("软件工程", "软件专业描述"));
	
	//将学院加到学校
	university.add(computer);
	university.add(infomation);
	
	//直接打印学校或学院
	university.print();
}
}
