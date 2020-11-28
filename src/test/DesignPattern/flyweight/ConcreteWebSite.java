package DesignPattern.flyweight;

public class ConcreteWebSite extends WebSite {
	// 共享的部分，内部状态
	private String type;

	public ConcreteWebSite(String type) {
		super();
		this.type = type;
	}

	@Override
	public void use(User user) {
		// TODO Auto-generated method stub
		System.out.println("网站发布形式为：" + type + "...使用者是" + user.getName());
	}

}
