package DesignPattern.flyweight;

public class ConcreteWebSite extends WebSite {
	// ����Ĳ��֣��ڲ�״̬
	private String type;

	public ConcreteWebSite(String type) {
		super();
		this.type = type;
	}

	@Override
	public void use(User user) {
		// TODO Auto-generated method stub
		System.out.println("��վ������ʽΪ��" + type + "...ʹ������" + user.getName());
	}

}
