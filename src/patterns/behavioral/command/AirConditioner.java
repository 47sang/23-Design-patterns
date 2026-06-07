package patterns.behavioral.command;

/**
 * 空调（AirConditioner）— 命令模式中的具体接收者。
 *
 * <p>实现 {@link Device} 接口，代表智能家居中的一台空调，
 * 可以执行打开和关闭操作。</p>
 *
 */
public class AirConditioner implements Device {

    /** 空调的名称（如"客厅空调"） */
    private final String name;

    /**
     * 构造一台空调。
     *
     * @param name 空调的名称
     */
    public AirConditioner(String name) {
        this.name = name;
    }

    /**
     * 打开空调。
     */
    @Override
    public void turnOn() {
        System.out.println("❄️  " + name + " 已打开（制冷模式 26°C）。");
    }

    /**
     * 关闭空调。
     */
    @Override
    public void turnOff() {
        System.out.println("❄️  " + name + " 已关闭。");
    }

    /**
     * 返回空调的名称。
     */
    @Override
    public String toString() {
        return name;
    }
}
