package DesignPattern.Adapter.object;

//ʹ��������
public class Phone {
	// ���
	public void charging(IVoltage5V iVoltage5V) {
		if (iVoltage5V.output5V() == 5) {
			System.out.println("���");
		} else {
			System.out.println("���ܳ��");
		}
	}
}
