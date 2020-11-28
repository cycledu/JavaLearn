package DesignPattern.decorator;

public class soy extends Decorator{

	public soy(Drink obj) {
		super(obj);
		setDes("soy");
		setPrice(1);
	}

}
