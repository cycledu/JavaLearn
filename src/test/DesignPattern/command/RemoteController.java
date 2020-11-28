package DesignPattern.command;

public class RemoteController {
    // �� ��ť����������
    Command[] onCommands;
    Command[] offCommands;

    // ִ�г���������
    Command undoCommand;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    // ����ť������Ҫ������
    public void setCommand(int no, Command oncommand, Command offCommand) {
        onCommands[no] = oncommand;
        offCommands[no] = offCommand;
    }

    // ���¿���ť
    public void onButonWasPushed(int no) {
        // �ҵ��㰴�µĿ���ť�������ö�Ӧ����
        onCommands[no].execute();
        // ��¼��εĲ��������ڳ���
        undoCommand = onCommands[no];
    }

    // ���¹ذ�ť
    public void offButtonWasPushed(int no) {
        // �ҵ��㰴�µĹصİ�ť�������ö�Ӧ����
        offCommands[no].execute();
        // ��¼��β��������ڳ���
        undoCommand = offCommands[no];
    }

    // ���³�����ť
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
