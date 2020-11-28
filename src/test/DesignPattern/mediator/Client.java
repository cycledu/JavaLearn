package DesignPattern.mediator;

public class Client {
	public static void main(String[] args) {
		// ����һ���н��߶���
		Mediator mediator = new ConcreteMediator();

		// ����Alarm ���Ҽ��뵽 ConcreteMediator �����HashMap
		Alarm alarm = new Alarm(mediator, "alarm");

		// ������CoffeeMachine ���󣬲� �Ҽ��뵽 ConcreteMediator �����HashMap
		CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffeeMachine");

		// ���� Curtains , �� �Ҽ��뵽 ConcreteMediator �����HashMap
		Curtains curtains = new Curtains(mediator, "curtains");
		TV tV = new TV(mediator, "TV");

		// �����ӷ�����Ϣ
		alarm.SendMessage(0);
		coffeeMachine.FinishCoffee();
		alarm.SendMessage(1);
	}
}
