package patterns.structural.facade;

/**
 * 空调子系统（子系统 / Subsystem）
 *
 * <p>外观模式中的子系统之一，负责控制智能家居的空调。</p>
 *
 * <h2>与外观模式的关系</h2>
 * <p>空调子系统独立管理自己的状态（开关、温度），
 * 外观类通过调用其方法来协调整体操作。</p>
 *
 * @see SmartHomeFacade 外观类
 */
class AirConditioner {

    /**
     * 空调名称。
     */
    private final String name;

    /**
     * 构造器：创建一个空调设备。
     *
     * @param name 空调名称，如"客厅空调"
     */
    AirConditioner(String name) {
        this.name = name;
    }

    /**
     * 打开空调。
     */
    public void on() {
        System.out.println("[空调] " + name + " 已打开，设定温度 26°C");
    }

    /**
     * 关闭空调。
     */
    public void off() {
        System.out.println("[空调] " + name + " 已关闭");
    }
}
