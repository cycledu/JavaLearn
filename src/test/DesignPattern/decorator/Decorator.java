package DesignPattern.decorator;
//��ʾ��obj�Ļ������ټ�Decorator(��obj����������һ��decorator)
public class Decorator extends Drink {
	private Drink obj;

	public Decorator(Drink obj) {
		this.obj = obj;
	}

	@Override
	public float cost() {
		//super.getPrice()��һ�μӽ�ȥ����Ʒ�ļ۸�obj.cost()���Ѿ���Ϻõ���Ʒ�ļ۸��п�����0
		return super.getPrice() + obj.cost();
	}

	@Override
	public String getDes() {
		// TODO Auto-generated method stub
		return "("+super.getDes() + " " + super.getPrice() + "&&" + obj.getDes()+")";
	}

}
