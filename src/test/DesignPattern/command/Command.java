package DesignPattern.command;

// ��������ӿڣ�ConcreteCommand��
public interface Command {
    // ִ�ж���(����)
    public void execute();

    // ��������(����)
    public void undo();
}
