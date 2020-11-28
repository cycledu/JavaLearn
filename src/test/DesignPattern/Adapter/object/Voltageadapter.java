package DesignPattern.Adapter.object;

//具体适配器类(去除继承改为将对象聚合到类中)
public class Voltageadapter implements IVoltage5V {

	private Voltage220V voltage220v;// 关联关系-聚合

	public Voltageadapter(Voltage220V voltage220v) {
		this.voltage220v = voltage220v;
	}

	@Override
	public int output5V() {
		int dst = 0;
		if (null != voltage220v) {
			// 获取220V电压
			int srcV = voltage220v.output220V();
			dst = srcV / 44;// 转换为5V
			System.out.println("适配成功，输出电压为："+dst);
		}
		return dst;
	}

}
