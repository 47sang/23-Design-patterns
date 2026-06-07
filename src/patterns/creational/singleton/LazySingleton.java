package patterns.creational.singleton;

/**
 * 懒汉式单例 — 双重检查锁（DCL）+ volatile
 *
 * <h2>实现原理</h2>
 * <p>延迟初始化（首次调用 {@link #getInstance()} 时才创建实例），
 * 使用双重检查锁（Double-Checked Locking）减少同步开销：</p>
 * <pre>
 * // 第一次检查（不加锁）：如果实例已存在，直接返回
 * if (instance == null) {
 *     // 加锁：防止多线程同时创建
 *     synchronized (LazySingleton.class) {
 *         // 第二次检查：防止多个线程同时通过第一次检查后重复创建
 *         if (instance == null) {
 *             instance = new LazySingleton(); // ⚠️ 需要 volatile 防止指令重排
 *         }
 *     }
 * }
 * </pre>
 *
 * <h2>⚠️ volatile 的必要性</h2>
 * <p>{@code instance = new LazySingleton()} 实际上分三步执行：</p>
 * <ol>
 *   <li>分配内存空间</li>
 *   <li>在内存空间中初始化对象</li>
 *   <li>将 instance 指向分配的内存地址</li>
 * </ol>
 * <p>由于指令重排，可能变成 1→3→2 的顺序。此时另一个线程可能拿到一个未完全初始化的对象。
 * {@code volatile} 禁止指令重排，保证 2 在 3 之前完成。</p>
 *
 * <h2>优缺点</h2>
 * <ul>
 *   <li><strong>优点</strong>：支持懒加载；大部分情况下无同步开销（第一次检查不锁）</li>
 *   <li><strong>缺点</strong>：代码较复杂；Java 5 之前 volatile 有 Bug，JDK 1.5 后修复</li>
 * </ul>
 *
 * <h2>适用场景</h2>
 * <ul>
 *   <li>实例创建开销大、但确实需要懒加载的场景</li>
 *   <li>对性能敏感的多线程环境</li>
 * </ul>
 *
 */
public class LazySingleton {

    /**
     * volatile 关键字 — 禁止指令重排，保证多线程可见性和有序性
     *
     * <p>没有 volatile 的情况下，另一个线程可能看到一个部分构造的对象（半初始化），
     * 导致空指针异常等难以排查的问题。</p>
     */
    private static volatile LazySingleton instance;

    /**
     * 私有构造函数 — 防止外部直接实例化
     */
    private LazySingleton() {
        System.out.println("  [LazySingleton] 实例已创建（首次调用 getInstance 时）");
    }

    /**
     * 获取单例实例的全局访问点（双重检查锁）
     *
     * <p>第一次检查（无锁）→ 加锁 → 第二次检查（有锁），
     * 既保证了线程安全，又避免了每次调用都加锁的性能开销。</p>
     *
     * @return 唯一的 LazySingleton 实例
     */
    public static LazySingleton getInstance() {
        // 第一次检查：实例已存在则直接返回，无需加锁
        if (instance == null) {
            // 类级别锁：同一时刻只有一个线程能进入此块
            synchronized (LazySingleton.class) {
                // 第二次检查：防止多个线程同时通过第一次检查后重复创建
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    /**
     * 业务方法 — 演示单例的功能
     *
     * @param message 要处理的消息
     */
    public void process(String message) {
        System.out.println("  [LazySingleton] 处理: " + message);
    }
}
