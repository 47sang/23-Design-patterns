package C.d;

/**
 * 命令
 * @author 周士钰
 * @date 2024/7/20 下午2:57
 */
public abstract class Command {
    private final Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行动作
     */
    public void execute() {
        receiver.action();
    }
}
