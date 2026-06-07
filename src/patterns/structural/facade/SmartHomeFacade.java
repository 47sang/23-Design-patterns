package patterns.structural.facade;

/**
 * 智能家居外观类（Facade）
 *
 * <p>外观模式的核心，为子系统（灯光、空调、窗帘、音乐播放器）
 * 提供统一的、简化的接口。</p>
 *
 * <h2>没有外观模式时的客户端代码</h2>
 * <pre>
 * // 回家模式：需要依次调用 4 个子系统的方法
 * light.on();
 * airConditioner.on();
 * curtain.open();
 * musicPlayer.play();
 *
 * // 离家模式：需要依次调用 4 个子系统的方法
 * light.off();
 * airConditioner.off();
 * curtain.close();
 * musicPlayer.stop();
 * </pre>
 *
 * <h2>使用外观模式后的客户端代码</h2>
 * <pre>
 * // 回家模式：只需调用一个方法
 * smartHomeFacade.comeHome();
 *
 * // 离家模式：只需调用一个方法
 * smartHomeFacade.leaveHome();
 * </pre>
 *
 * <h2>外观模式的核心思想</h2>
 * <ul>
 *   <li>Facade 知道哪些子系统负责处理哪些请求</li>
 *   <li>Facade 将客户端的请求委派给适当的子系统对象</li>
 *   <li>客户端只需要和 Facade 交互，不需要了解子系统的内部结构</li>
 *   <li>子系统不需要知道 Facade 的存在</li>
 * </ul>
 *
 * <h2>与中介者模式的区别</h2>
 * <ul>
 *   <li><strong>外观</strong>：单向封装，子系统不知道 Facade 的存在</li>
 *   <li><strong>中介者</strong>：双向交互，各同事都知道中介者，中介者也认识所有同事</li>
 * </ul>
 *
 * @see Light 灯光子系统
 * @see AirConditioner 空调子系统
 * @see Curtain 窗帘子系统
 * @see MusicPlayer 音乐播放器子系统
 */
public class SmartHomeFacade {

    /**
     * 灯光子系统。
     *
     * <p>外观类持有所有子系统的引用，
     * 在高层操作中协调它们的工作。</p>
     */
    private final Light light;

    /**
     * 空调子系统。
     */
    private final AirConditioner airConditioner;

    /**
     * 窗帘子系统。
     */
    private final Curtain curtain;

    /**
     * 音乐播放器子系统。
     */
    private final MusicPlayer musicPlayer;

    /**
     * 构造器：初始化所有子系统。
     *
     * <p>外观类在构造时持有所有子系统的引用，
     * 后续可以通过这些引用协调子系统的操作。</p>
     *
     * @param light          灯光子系统
     * @param airConditioner 空调子系统
     * @param curtain        窗帘子系统
     * @param musicPlayer    音乐播放器子系统
     */
    public SmartHomeFacade(Light light, AirConditioner airConditioner,
                           Curtain curtain, MusicPlayer musicPlayer) {
        this.light = light;
        this.airConditioner = airConditioner;
        this.curtain = curtain;
        this.musicPlayer = musicPlayer;
    }

    /**
     * 回家模式：一键执行所有回家操作。
     *
     * <p>依次执行：开灯 + 开空调 + 开窗帘 + 播放音乐。
     * 客户端只需调用这一个方法，不需要知道内部有哪些子系统参与。</p>
     */
    public void comeHome() {
        System.out.println(">>> 执行回家模式 <<<");
        light.on();
        airConditioner.on();
        curtain.open();
        musicPlayer.play();
        System.out.println(">>> 回家模式执行完毕 <<<");
    }

    /**
     * 离家模式：一键执行所有离家操作。
     *
     * <p>依次执行：关灯 + 关空调 + 拉窗帘 + 停止音乐。
     * 客户端只需调用这一个方法，不需要知道内部有哪些子系统参与。</p>
     */
    public void leaveHome() {
        System.out.println(">>> 执行离家模式 <<<");
        light.off();
        airConditioner.off();
        curtain.close();
        musicPlayer.stop();
        System.out.println(">>> 离家模式执行完毕 <<<");
    }
}
