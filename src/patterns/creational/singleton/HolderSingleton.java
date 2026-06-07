package patterns.creational.singleton;

/**
 * 静态内部类单例 — 推荐实现方式
 *
 * <h2>实现原理（利用 JVM 类加载机制）</h2>
 * <pre>
 * // 调用 getInstance() 时：
 * // 1. JVM 加载 LazyHolderSingleton 类（外部类已加载，但内部类尚未加载）
 * // 2. 首次引用 Holder 类 → 触发 JVM 加载 Holder
 * // 3. 类加载过程是线程安全的（JVM 保证）→ INSTANCE 初始化天然线程安全
 * // 4. 未被调用时，Holder 不会被加载 → 实现懒加载
 * </pre>
 *
 * <h2>为什么叫"Holder"而不是"SingletonHolder"</h2>
 * <p>原始代码中使用 {@code SingletonHolder} 造成命名混淆：
 * "SingletonHolder" 听起来像是一个持有 Singleton 的工具类。
 * 标准做法是命名为 {@code Holder}，表示它"持有"单例实例，
 * 类名本身已处于 {@code LazyHolderSingleton} 的作用域下，
 * 含义清晰：这是一个内部 Holder，属于 LazyHolderSingleton。</p>
 *
 * <h2>优缺点</h2>
 * <ul>
 *   <li><strong>优点</strong>：实现简洁；懒加载；线程安全（JVM 保证）；无同步开销</li>
 *   <li><strong>缺点</strong>：无法防止通过反射调用私有构造器创建新实例</li>
 * </ul>
 *
 * <h2>适用场景</h2>
 * <ul>
 *   <li>大多数单例场景的<strong>首选实现</strong></li>
 *   <li>需要懒加载 + 线程安全 + 代码简洁</li>
 * </ul>
 *
 * @see LazySingleton 双重检查锁实现
 * @see EnumSingleton 枚举实现（防反射/序列化）
 */
public class HolderSingleton {

    /**
     * 私有构造函数 — 防止外部直接实例化
     */
    private HolderSingleton() {
        System.out.println("  [HolderSingleton] 实例已创建（首次调用 getInstance 时）");
    }

    /**
     * 静态内部类 — 持有单例实例
     *
     * <p>关键设计：</p>
     * <ul>
     *   <li>{@code static} — 使内部类可以独立于外部类实例化</li>
     *   <li>{@code final} — 防止被继承修改</li>
     *   <li>只有在 {@link #getInstance()} 首次被调用时才会被 JVM 加载 → 懒加载</li>
     *   <li>类加载过程 JVM 保证线程安全 → 无需 synchronized</li>
     * </ul>
     */
    private static final class Holder {
        /**
         * 单例实例 — 静态常量
         *
         * <p>JVM 在加载 Holder 类时初始化此实例，
         * 类加载的线程安全性保证此处只会执行一次。</p>
         */
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    /**
     * 获取单例实例的全局访问点
     *
     * <p>调用此方法时，JVM 才会加载 {@link Holder} 类，
     * 从而实现懒加载。加载过程由 JVM 保证线程安全。</p>
     *
     * @return 唯一的 HolderSingleton 实例
     */
    public static HolderSingleton getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 业务方法 — 演示单例的功能
     *
     * @param message 要处理的消息
     */
    public void process(String message) {
        System.out.println("  [HolderSingleton] 处理: " + message);
    }
}
