package patterns.creational.singleton;

/**
 * 饿汉式单例 — 静态常量方式
 *
 * <h2>实现原理</h2>
 * <p>利用 Java 类加载机制保证线程安全：
 * 类加载时即初始化实例，JVM 保证类加载的线程安全性，
 * 因此天然线程安全，且实例始终唯一。</p>
 *
 * <h2>优缺点</h2>
 * <ul>
 *   <li><strong>优点</strong>：实现简单、线程安全、无同步开销</li>
 *   <li><strong>缺点</strong>：不支持懒加载 — 类加载时就初始化，即使从未被使用也会创建实例</li>
 * </ul>
 *
 * <h2>适用场景</h2>
 * <ul>
 *   <li>实例创建开销小的单例（如无状态工具类）</li>
 *   <li>确定一定会被使用的单例</li>
 * </ul>
 *
 */
public class EagerSingleton {

    /**
     * 静态常量 — 类加载时初始化
     *
     * <p>JVM 保证类加载的线程安全，因此此实例的创建天然线程安全。
     * 使用 {@code final} 修饰，防止被意外修改引用。</p>
     */
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    /**
     * 私有构造函数 — 防止外部直接实例化
     */
    private EagerSingleton() {
        System.out.println("  [EagerSingleton] 实例已创建（类加载时）");
    }

    /**
     * 获取单例实例的全局访问点
     *
     * @return 唯一的 EagerSingleton 实例
     */
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 业务方法 — 演示单例的功能
     *
     * @param message 要处理的消息
     */
    public void process(String message) {
        System.out.println("  [EagerSingleton] 处理: " + message);
    }
}
