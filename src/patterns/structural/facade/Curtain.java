package patterns.structural.facade;

/**
 * 窗帘子系统（子系统 / Subsystem）
 *
 * <p>外观模式中的子系统之一，负责控制智能家居的窗帘。</p>
 *
 * <h2>与外观模式的关系</h2>
 * <p>窗帘子系统独立管理自己的开合状态，
 * 外观类通过调用其方法来协调整体操作。</p>
 *
 * @see SmartHomeFacade 外观类
 */
class Curtain {

    /**
     * 窗帘名称。
     */
    private final String name;

    /**
     * 构造器：创建一个窗帘设备。
     *
     * @param name 窗帘名称，如"客厅窗帘"
     */
    Curtain(String name) {
        this.name = name;
    }

    /**
     * 打开窗帘。
     */
    public void open() {
        System.out.println("[窗帘] " + name + " 已打开");
    }

    /**
     * 关闭窗帘（拉上）。
     */
    public void close() {
        System.out.println("[窗帘] " + name + " 已拉上");
    }
}
