package patterns.creational.singleton;

/**
 * 枚举单例 — 最安全的实现方式
 *
 * <h2>实现原理</h2>
 * <p>Java 枚举类型由 JVM 保证：</p>
 * <ul>
 *   <li>枚举实例在类加载时自动创建，天然单例</li>
 *   <li>枚举的构造函数自动设为 private，无法通过 new 创建实例</li>
 *   <li>枚举天然防御<strong>反射攻击</strong> — 反射无法调用枚举的构造函数创建新实例</li>
 *   <li>枚举天然防御<strong>序列化攻击</strong> — 反序列化时 JVM 保证返回原有实例</li>
 * </ul>
 *
 * <h2>优缺点</h2>
 * <ul>
 *   <li><strong>优点</strong>：最安全（防反射/序列化）；实现最简洁（仅一两行代码）；线程安全</li>
 *   <li><strong>缺点</strong>：不支持懒加载（类加载时即初始化）；无法延迟到首次使用时才创建</li>
 * </ul>
 *
 * <h2>适用场景</h2>
 * <ul>
 *   <li>需要最高安全保证的单例（防反射/防序列化）</li>
 *   <li>不介意饿汉式初始化的场景</li>
 *   <li>Effective Java 第 3 条推荐：单例的最佳实践</li>
 * </ul>
 *
 * <h2>序列化安全原理</h2>
 * <p>其他单例实现需要手动实现 {@code readResolve()} 方法来防御序列化攻击，
 * 而枚举由 JVM 自动处理：枚举的 {@code readObject()} 方法直接返回 {@code EnumSingleton.INSTANCE}。</p>
 *
 * @see EagerSingleton 饿汉式实现
 * @see LazySingleton 双重检查锁实现
 * @see HolderSingleton 静态内部类实现
 */
public enum EnumSingleton {

    /**
     * 唯一实例 — JVM 保证枚举值的单例性
     *
     * <p>枚举的每个值在类加载时创建一次，JVM 保证全局唯一。
     * 这就是 EnumSingleton 的唯一实例。</p>
     */
    INSTANCE;

    /**
     * 业务状态 — 演示枚举单例也可以有状态
     */
    private String status = "就绪";

    /**
     * 业务方法 — 演示单例的功能
     *
     * @param message 要处理的消息
     */
    public void process(String message) {
        System.out.println("  [EnumSingleton] 处理: " + message);
    }

    /**
     * 获取当前状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置当前状态
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
