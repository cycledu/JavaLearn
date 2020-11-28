package DesignPattern.bridge;

public class ViVo implements Brand {

	@Override
	public void open() {
		System.out.println("ViVO����");
	}

	@Override
	public void close() {
		System.out.println("ViVO�ػ�");
	}

	@Override
	public void call() {
		System.out.println("ViVo��绰");
	}

}
