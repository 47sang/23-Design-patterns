package patterns.behavioral.command;

/**
 * 关灯命令（LightOffCommand）— 命令模式中的具体命令。
 *
 * <p>封装"关闭灯"这个请求，持有灯的引用，
 * 执行时调用灯的 {@code turnOff()} 方法。</p>
 *
 */
public class LightOffCommand extends Command {

    /**
     * 构造一个关灯命令。
     *
     * @param light 要关闭的灯（接收者）
     */
    public LightOffCommand(Light light) {
        super(light);
    }

    /**
     * 执行关灯操作。
     */
    @Override
    public void execute() {
        receiver.turnOff();
    }

    /**
     * 撤销关灯操作 — 即打开灯。
     */
    @Override
    public void undo() {
        System.out.println("↩️  撤销关灯操作：");
        receiver.turnOn();
    }
}
