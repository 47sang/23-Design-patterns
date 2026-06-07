package patterns.behavioral.command;

/**
 * 关空调命令（ACOffCommand）— 命令模式中的具体命令。
 *
 * <p>封装"关闭空调"这个请求，执行时调用空调的 {@code turnOff()} 方法。</p>
 *
 */
public class ACOffCommand extends Command {

    /**
     * 构造一个关空调命令。
     *
     * @param ac 要关闭的空调（接收者）
     */
    public ACOffCommand(AirConditioner ac) {
        super(ac);
    }

    /**
     * 执行关空调操作。
     */
    @Override
    public void execute() {
        receiver.turnOff();
    }

    /**
     * 撤销关空调操作 — 即打开空调。
     */
    @Override
    public void undo() {
        System.out.println("↩️  撤销关空调操作：");
        receiver.turnOn();
    }
}
