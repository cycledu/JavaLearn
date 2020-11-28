package DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

//Univerity就是Composite，可以管理College
public class University extends OrganizationComponent {

	// 向list中存子节点
	List<OrganizationComponent> organizationComponents = new ArrayList<>();

	public University(String name, String des) {
		super(name, des);
	}

	// composite需要重写具体的操作方法，来操作子节点
	@Override
	protected void add(OrganizationComponent organizationComponent) {
		organizationComponents.add(organizationComponent);
	}

	@Override
	protected void remove(OrganizationComponent organizationComponent) {
		organizationComponents.remove(organizationComponent);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public String getDes() {
		return super.getDes();
	}

	// print方法，就是输出University 包含的学院
	@Override
	protected void print() {
		System.out.println(getName());
		// 遍历organizationComponents,调用存在list中子节点的打印方法
		for (OrganizationComponent organizationComponent : organizationComponents) {
			organizationComponent.print();
		}
	}

}
