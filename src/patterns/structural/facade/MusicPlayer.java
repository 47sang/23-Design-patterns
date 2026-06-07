package patterns.structural.facade;

/**
 * 音乐播放器子系统（子系统 / Subsystem）
 *
 * <p>外观模式中的子系统之一，负责控制智能家居的音乐播放器。</p>
 *
 * <h2>与外观模式的关系</h2>
 * <p>音乐播放器子系统独立管理自己的播放状态，
 * 外观类通过调用其方法来协调整体操作。</p>
 *
 * @see SmartHomeFacade 外观类
 */
class MusicPlayer {

    /**
     * 音乐播放器名称。
     */
    private final String name;

    /**
     * 构造器：创建一个音乐播放器设备。
     *
     * @param name 播放器名称，如"客厅音响"
     */
    MusicPlayer(String name) {
        this.name = name;
    }

    /**
     * 播放音乐。
     */
    public void play() {
        System.out.println("[音乐] " + name + " 正在播放音乐");
    }

    /**
     * 停止播放。
     */
    public void stop() {
        System.out.println("[音乐] " + name + " 已停止播放");
    }
}
