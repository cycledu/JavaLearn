package DesignPattern.decorator;

public class milk extends Decorator{

	public milk(Drink obj) {
		super(obj);
		setDes("milk");
		setPrice(2.0f);
	}

}
