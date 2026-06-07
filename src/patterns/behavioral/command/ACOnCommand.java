package patterns.behavioral.command;

/**
 * 开空调命令（ACOnCommand）— 命令模式中的具体命令。
 *
 * <p>封装"打开空调"这个请求，执行时调用空调的 {@code turnOn()} 方法。</p>
 *
 */
public class ACOnCommand extends Command {

    /**
     * 构造一个开空调命令。
     *
     * @param ac 要打开的空调（接收者）
     */
    public ACOnCommand(AirConditioner ac) {
        super(ac);
    }

    /**
     * 执行开空调操作。
     */
    @Override
    public void execute() {
        receiver.turnOn();
    }

    /**
     * 撤销开空调操作 — 即关闭空调。
     */
    @Override
    public void undo() {
        System.out.println("↩️  撤销开空调操作：");
        receiver.turnOff();
    }
}
