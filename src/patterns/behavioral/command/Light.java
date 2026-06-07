package patterns.behavioral.command;

/**
 * 灯（Light）— 命令模式中的具体接收者（Concrete Receiver）。
 *
 * <p>实现 {@link Device} 接口，代表智能家居中的一盏灯，
 * 可以执行打开和关闭操作。</p>
 *
 */
public class Light implements Device {

    /** 灯的名称（如"客厅灯"、"卧室灯"） */
    private final String name;

    /**
     * 构造一盏灯。
     *
     * @param name 灯的名称，方便区分不同位置的灯
     */
    public Light(String name) {
        this.name = name;
    }

    /**
     * 打开灯。
     *
     * @return 灯的名称，用于命令执行时打印状态
     */
    @Override
    public void turnOn() {
        System.out.println("💡 " + name + " 已打开。");
    }

    /**
     * 关闭灯。
     *
     * @return 灯的名称，用于命令执行时打印状态
     */
    @Override
    public void turnOff() {
        System.out.println("💡 " + name + " 已关闭。");
    }

    /**
     * 返回灯的名称。
     */
    @Override
    public String toString() {
        return name;
    }
}
