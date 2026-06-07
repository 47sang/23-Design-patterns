package patterns.behavioral.command;

/**
 * 设备接口（Device）— 命令模式中的接收者（Receiver）接口。
 *
 * <h2>设计意图</h2>
 * <p>接收者是实际执行操作的对象。命令对象不直接执行操作，
 * 而是将执行委托给接收者。这样命令对象只关注"做什么"，
 * 接收者负责"怎么做"。</p>
 *
 * <h2>与命令模式的关系</h2>
 * <p>具体的命令类（如 {@link LightOnCommand}）持有本接口的引用，
 * 在 {@code execute()} 中调用接收者的方法。
 * 通过面向接口编程，命令类不依赖具体的设备实现，
 * 符合依赖倒转原则。</p>
 *
 */
public interface Device {

    /** 打开设备 */
    void turnOn();

    /** 关闭设备 */
    void turnOff();
}
