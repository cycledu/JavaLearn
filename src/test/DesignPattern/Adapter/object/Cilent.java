package DesignPattern.Adapter.object;

public class Cilent {
	public static void main(String[] args) {
		System.out.println("ÀàÊÊÅäÄ£Ê½");
		Phone phone = new Phone();
		phone.charging(new Voltageadapter(new Voltage220V()));
	}
}
