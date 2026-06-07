package patterns.structural.facade;

/**
 * 灯光子系统（子系统 / Subsystem）
 *
 * <p>外观模式中的子系统之一，负责控制智能家居的灯光。</p>
 *
 * <h2>与外观模式的关系</h2>
 * <p>灯光子系统不知道 SmartHomeFacade（外观类）的存在，
 * 它只提供自己的开关能力。外观类在需要时调用灯光子系统的方法，
 * 将多个子系统的操作组合成一个高层操作（如"回家模式"）。</p>
 *
 * @see SmartHomeFacade 外观类
 */
class Light {

    /**
     * 灯光名称。
     */
    private final String name;

    /**
     * 构造器：创建一个灯光设备。
     *
     * @param name 灯光名称，如"客厅灯"、"卧室灯"
     */
    Light(String name) {
        this.name = name;
    }

    /**
     * 开灯。
     */
    public void on() {
        System.out.println("[灯光] " + name + " 已打开");
    }

    /**
     * 关灯。
     */
    public void off() {
        System.out.println("[灯光] " + name + " 已关闭");
    }
}
