package patterns.behavioral.command;

/**
 * 开灯命令（LightOnCommand）— 命令模式中的具体命令。
 *
 * <p>封装"打开灯"这个请求，持有灯的引用，
 * 执行时调用灯的 {@code turnOn()} 方法。</p>
 *
 */
public class LightOnCommand extends Command {

    /**
     * 构造一个开灯命令。
     *
     * @param light 要打开的灯（接收者）
     */
    public LightOnCommand(Light light) {
        super(light);
    }

    /**
     * 执行开灯操作。
     */
    @Override
    public void execute() {
        receiver.turnOn();
    }

    /**
     * 撤销开灯操作 — 即关闭灯。
     */
    @Override
    public void undo() {
        System.out.println("↩️  撤销开灯操作：");
        receiver.turnOff();
    }
}
