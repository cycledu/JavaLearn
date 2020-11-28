package DesignPattern.bridge;

public class ViVo implements Brand {

	@Override
	public void open() {
		System.out.println("ViVO开机");
	}

	@Override
	public void close() {
		System.out.println("ViVO关机");
	}

	@Override
	public void call() {
		System.out.println("ViVo打电话");
	}

}
