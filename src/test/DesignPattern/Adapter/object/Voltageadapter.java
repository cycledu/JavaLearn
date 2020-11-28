package DesignPattern.Adapter.object;

//������������(ȥ���̳и�Ϊ������ۺϵ�����)
public class Voltageadapter implements IVoltage5V {

	private Voltage220V voltage220v;// ������ϵ-�ۺ�

	public Voltageadapter(Voltage220V voltage220v) {
		this.voltage220v = voltage220v;
	}

	@Override
	public int output5V() {
		int dst = 0;
		if (null != voltage220v) {
			// ��ȡ220V��ѹ
			int srcV = voltage220v.output220V();
			dst = srcV / 44;// ת��Ϊ5V
			System.out.println("����ɹ��������ѹΪ��"+dst);
		}
		return dst;
	}

}
