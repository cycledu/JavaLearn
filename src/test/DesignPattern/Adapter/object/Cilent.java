package DesignPattern.Adapter.object;

public class Cilent {
	public static void main(String[] args) {
		System.out.println("������ģʽ");
		Phone phone = new Phone();
		phone.charging(new Voltageadapter(new Voltage220V()));
	}
}
