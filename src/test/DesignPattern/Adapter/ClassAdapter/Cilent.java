package DesignPattern.Adapter.ClassAdapter;

public class Cilent {
	public static void main(String[] args) {
		System.out.println("������ģʽ");
		Phone phone = new Phone();
		phone.charging(new Voltageadapter());
	}
}
