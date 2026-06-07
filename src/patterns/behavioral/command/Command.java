package patterns.behavioral.command;

/**
 * 抽象命令（Command）— 命令模式的核心抽象角色。
 *
 * <h2>设计意图</h2>
 * <p>将"请求"封装为一个对象，使得请求的发送者（调用者）
 * 和请求的接收者（具体设备）解耦。
 * 命令对象只持有接收者接口的引用，不依赖具体设备类。</p>
 *
 * <h2>核心方法</h2>
 * <ul>
 *   <li>{@link #execute()} — 执行命令，调用接收者的操作方法</li>
 *   <li>{@link #undo()} — 撤销命令，恢复执行前的状态</li>
 * </ul>
 *
 * <h2>具体子类</h2>
 * <ul>
 *   <li>{@link LightOnCommand} / {@link LightOffCommand}</li>
 *   <li>{@link ACOnCommand} / {@link ACOffCommand}</li>
 *   <li>{@link FanOnCommand} / {@link FanOffCommand}</li>
 * </ul>
 *
 */
public abstract class Command {

    /** 接收者（持有接口引用，不依赖具体设备类） */
    protected final Device receiver;

    /**
     * 构造一个命令。
     *
     * @param receiver 执行该命令的设备（接收者）
     */
    protected Command(Device receiver) {
        this.receiver = receiver;
    }

    /**
     * 执行命令 — 调用接收者的具体操作方法。
     */
    public abstract void execute();

    /**
     * 撤销命令 — 恢复执行前的状态。
     *
     * <p>默认实现为空（不撤销），具体子类根据命令类型提供撤销逻辑。
     * 例如：开灯命令的撤销是关灯，关灯命令的撤销是开灯。</p>
     */
    public void undo() {
        // 默认不撤销，子类可覆盖
    }
}
