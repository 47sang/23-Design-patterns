package patterns.behavioral.command;

/**
 * 遥控器（RemoteController）— 命令模式中的调用者（Invoker）。
 *
 * <h2>设计意图</h2>
 * <p>遥控器持有多个命令对象，用户按下遥控器上的按钮时，
 * 遥控器调用对应命令的 {@link Command#execute()} 方法。
 * 遥控器不关心具体是什么设备、具体执行什么操作，
 * 只关心调用命令的 {@code execute()} 方法。
 * 这使得遥控器与具体设备完全解耦。</p>
 *
 * <h2>撤销功能</h2>
 * <p>遥控器维护一个命令历史栈，每次执行命令前将当前命令压栈，
 * 撤销时从栈顶弹出上一个命令并调用其 {@code undo()} 方法。</p>
 *
 */
public class RemoteController {

    /** 命令历史栈，用于实现撤销功能 */
    private final java.util.Stack<Command> history = new java.util.Stack<>();

    /**
     * 执行一个命令，并将其记录到历史栈中。
     *
     * @param command 要执行的命令对象
     */
    public void pressButton(Command command) {
        System.out.println("📱 遥控器按下按钮，执行命令...");
        command.execute();
        history.push(command);
    }

    /**
     * 撤销上一个命令。
     *
     * <p>从历史栈中弹出最近一次执行的命令，调用其 {@code undo()} 方法。
     * 如果没有任何历史记录，则打印提示信息。</p>
     */
    public void pressUndo() {
        if (history.isEmpty()) {
            System.out.println("📱 没有可撤销的操作。");
            return;
        }
        System.out.println("📱 遥控器按下撤销按钮，恢复上一个状态...");
        Command lastCommand = history.pop();
        lastCommand.undo();
    }
}
