package DesignPattern.Composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent{
	// ��list�д��ӽڵ�
		List<OrganizationComponent> organizationComponents = new ArrayList<>();

		public College(String name, String des) {
			super(name, des);
		}

		// composite��Ҫ��д����Ĳ����������������ӽڵ�
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

		// print�������������College ������רҵ
		@Override
		protected void print() {
			System.out.println("----------" + getName() + "---------------");
			// ����organizationComponents,���ô���list���ӽڵ�Ĵ�ӡ����
			for (OrganizationComponent organizationComponent : organizationComponents) {
				organizationComponent.print();
			}
		}


}
