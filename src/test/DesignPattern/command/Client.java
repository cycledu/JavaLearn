package DesignPattern.command;

public class Client {
    public static void main(String[] args) {
        // ʹ���������ģʽ�����ͨ��ң�������Ե�ƵĲ���
        // ������ƵĶ���(������)
        LightReceiver lightReceiver = new LightReceiver();

        // ���������صĿ�������
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        // ����һ��ң����
        RemoteController remoteController = new RemoteController();

        // ��ң������invoker�������ߣ������������ no=0�ǵ�ƵĿ��͹صĲ���
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("-----------���µƵĿ���ť------------");
        remoteController.onButonWasPushed(0);
        System.out.println("-----------���µƵĹذ�ť-------------");
        remoteController.offButtonWasPushed(0);
        System.out.println("------------���³�����ť----------------");
        remoteController.undoButtonWasPushed();
    }
}
