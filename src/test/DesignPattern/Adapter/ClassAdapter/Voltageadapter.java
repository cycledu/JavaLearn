package DesignPattern.Adapter.ClassAdapter;

//������������
public class Voltageadapter extends Voltage220V implements IVoltage5V{

	@Override
	public int output5V() {
		//��ȡ220V��ѹ
		int srcV=output220V();
		int dstV=srcV/44;//ת��Ϊ5V
		return dstV;
	}

}
