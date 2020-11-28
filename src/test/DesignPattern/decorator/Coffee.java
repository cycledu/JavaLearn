package DesignPattern.decorator;

public class Coffee extends Drink{

	@Override
	public float cost() {
		// TODO Auto-generated method stub
		return getPrice();
	}
}
