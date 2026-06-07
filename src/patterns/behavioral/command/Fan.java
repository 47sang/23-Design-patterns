package patterns.behavioral.command;

/**
 * 风扇（Fan）— 命令模式中的具体接收者。
 *
 * <p>实现 {@link Device} 接口，代表智能家居中的一台风扇，
 * 可以执行打开和关闭操作。</p>
 *
 */
public class Fan implements Device {

    /** 风扇的名称（如"卧室风扇"） */
    private final String name;

    /**
     * 构造一台风扇。
     *
     * @param name 风扇的名称
     */
    public Fan(String name) {
        this.name = name;
    }

    /**
     * 打开风扇。
     */
    @Override
    public void turnOn() {
        System.out.println("🌀 " + name + " 已打开（一档风速）。");
    }

    /**
     * 关闭风扇。
     */
    @Override
    public void turnOff() {
        System.out.println("🌀 " + name + " 已关闭。");
    }

    /**
     * 返回风扇的名称。
     */
    @Override
    public String toString() {
        return name;
    }
}
