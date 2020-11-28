package DesignPattern.com.principle;

public class DependencyPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangHong changHong = new ChangHong();
		// ͨ���ӿڽ�����������
		// OpenAndClose openAndClose = new OpenAndClose();
		// openAndClose.open(changHong);

		// ͨ��������������������
		// OpenAndClose openAndClose = new OpenAndClose(changHong);
		// openAndClose.open();
		// ͨ��setter����������������
		OpenAndClose openAndClose = new OpenAndClose();
		openAndClose.setTv(changHong);
		openAndClose.open();

	}

}

// ��ʽ1�� ͨ���ӿڴ���ʵ��������ͨ�����ӿ�ITV��ʵ����ChangHong��ʵ������ʵ��IOpenAndClose��ʵ����OpenAndClose����ֱ�ӵ���ʵ���ķ�����
// ���صĽӿ�
//interface IOpenAndClose {
//	public void open(ITV tv); // ���󷽷�,���սӿ�
//}
//
//// ʵ�ֽӿ�
//class OpenAndClose implements IOpenAndClose {
//	public void open(ITV tv) {
//		tv.play();
//	}
//}

// ��ʽ2:
// ͨ�����췽���������ݣ�ͨ����ITV��ʵ����ChangHong��ʵ������ʵ�ֽӿ�IOpenAndClose��ʵ����OpenAndClose�е��вι������У�����open������ʹ��this�ؼ���ʹ�÷�����
//interface IOpenAndClose {
//	public void open(); // ���󷽷�
//}
//
//class OpenAndClose implements IOpenAndClose {
//	public ITV tv; // ��Ա
//
//	public OpenAndClose(ITV tv) { // ������
//		this.tv = tv;
//	}
//
//	public void open() {
//		this.tv.play();
//	}
//}

// ��ʽ3 ,
// ͨ��setter��������(ͨ��setter������ITV��ʵ����ChangHong��ʵ������ʵ�ֽӿ�IOpenAndClose��ʵ����OpenAndClose��setter�����У���ʹ��this�ؼ���ִ�з���)
interface IOpenAndClose {
	public void open(); // ���󷽷�
	public void setTv(ITV tv);
}

class OpenAndClose implements IOpenAndClose {
	private ITV tv;

	public void setTv(ITV tv) {
		this.tv = tv;
	}

	public void open() {
		this.tv.play();
	}
}


//���ò���
interface ITV { // ITV�ӿ�
	public void play();
}

class ChangHong implements ITV {
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("������ӻ�����");
	}

}
