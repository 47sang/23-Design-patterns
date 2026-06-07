package patterns.behavioral.command;

/**
 * 关风扇命令（FanOffCommand）— 命令模式中的具体命令。
 *
 * <p>封装"关闭风扇"这个请求，执行时调用风扇的 {@code turnOff()} 方法。</p>
 *
 */
public class FanOffCommand extends Command {

    /**
     * 构造一个关风扇命令。
     *
     * @param fan 要关闭的风扇（接收者）
     */
    public FanOffCommand(Fan fan) {
        super(fan);
    }

    /**
     * 执行关风扇操作。
     */
    @Override
    public void execute() {
        receiver.turnOff();
    }

    /**
     * 撤销关风扇操作 — 即打开风扇。
     */
    @Override
    public void undo() {
        System.out.println("↩️  撤销关风扇操作：");
        receiver.turnOn();
    }
}
