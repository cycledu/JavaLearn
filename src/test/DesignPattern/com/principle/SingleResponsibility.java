package DesignPattern.com.principle;

public class SingleResponsibility {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.run("Ħ�г�");
		vehicle.run("����");
		vehicle.run("Ħ�г�");
	}
}

class Vehicle {
	public void run(String vehicle) {
		System.out.println(vehicle + "�ڹ�·���ܡ�����");
	}
}