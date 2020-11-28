package DesignPattern.decorator;
//表示在obj的基础上再加Decorator(在obj的外面再套一层decorator)
public class Decorator extends Drink {
	private Drink obj;

	public Decorator(Drink obj) {
		this.obj = obj;
	}

	@Override
	public float cost() {
		//super.getPrice()这一次加进去的物品的价格，obj.cost()是已经组合好的饮品的价格，有可能是0
		return super.getPrice() + obj.cost();
	}

	@Override
	public String getDes() {
		// TODO Auto-generated method stub
		return "("+super.getDes() + " " + super.getPrice() + "&&" + obj.getDes()+")";
	}

}
