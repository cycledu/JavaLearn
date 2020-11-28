package DesignPattern.Adapter.object;

//使用适配器
public class Phone {
	// 充电
	public void charging(IVoltage5V iVoltage5V) {
		if (iVoltage5V.output5V() == 5) {
			System.out.println("充电");
		} else {
			System.out.println("不能充电");
		}
	}
}
