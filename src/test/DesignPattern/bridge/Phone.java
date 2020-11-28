package DesignPattern.bridge;

public abstract class Phone {
	private Brand brand;// �ۺ�Ʒ��

	public Phone(Brand brand) {
		super();
		this.brand = brand;
	}

	protected void open() {
		this.brand.open();
	}

	protected void close() {
		brand.close();
	}

	protected void call() {
		brand.call();
	}

}
