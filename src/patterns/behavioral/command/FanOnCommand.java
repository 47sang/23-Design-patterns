package patterns.behavioral.command;

/**
 * 开风扇命令（FanOnCommand）— 命令模式中的具体命令。
 *
 * <p>封装"打开风扇"这个请求，执行时调用风扇的 {@code turnOn()} 方法。</p>
 *
 */
public class FanOnCommand extends Command {

    /**
     * 构造一个开风扇命令。
     *
     * @param fan 要打开的风扇（接收者）
     */
    public FanOnCommand(Fan fan) {
        super(fan);
    }

    /**
     * 执行开风扇操作。
     */
    @Override
    public void execute() {
        receiver.turnOn();
    }

    /**
     * 撤销开风扇操作 — 即关闭风扇。
     */
    @Override
    public void undo() {
        System.out.println("↩️  撤销开风扇操作：");
        receiver.turnOff();
    }
}
