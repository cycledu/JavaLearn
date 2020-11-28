package DesignPattern.factory.simplefactory.Pizza;

import DesignPattern.factory.Pizza;

public class CheesePizza extends Pizza {

	public CheesePizza() {
		super("cheese");
	}

	@Override
	public void prepare() {
		System.out.println("Ö¥Ê¿ÅûÈø");
	}

}
