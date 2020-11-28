package DesignPattern.Adapter.ClassAdapter;

//具体适配器类
public class Voltageadapter extends Voltage220V implements IVoltage5V{

	@Override
	public int output5V() {
		//获取220V电压
		int srcV=output220V();
		int dstV=srcV/44;//转换为5V
		return dstV;
	}

}
