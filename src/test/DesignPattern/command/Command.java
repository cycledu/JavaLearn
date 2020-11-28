package DesignPattern.command;

// 创建命令接口（ConcreteCommand）
public interface Command {
    // 执行动作(操作)
    public void execute();

    // 撤销动作(操作)
    public void undo();
}
