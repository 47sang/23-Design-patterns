/**
 * 单例模式（Singleton Pattern）
 *
 * <h2>模式说明</h2>
 * <p>确保一个类仅有一个实例，并提供一个访问它的全局访问点。</p>
 *
 * <h2>为什么需要单例？</h2>
 * <p>某些资源（如线程池、数据库连接池、配置管理器）在整个应用中只需要一个实例：
 * <ul>
 *   <li>节省内存，避免创建多个重复对象</li>
 *   <li>避免资源竞争（如多个连接池实例同时操作数据库）</li>
 *   <li>提供全局统一的访问入口</li>
 * </ul>
 *
 * <h2>常见实现方式对比</h2>
 * <table>
 *   <tr>
 *     <th>实现方式</th>
 *     <th>线程安全</th>
 *     <th>懒加载</th>
 *     <th>推荐度</th>
 *   </tr>
 *   <tr><td>饿汉式（静态常量）</td><td>✅</td><td>❌</td><td>⭐⭐⭐</td></tr>
 *   <tr><td>懒汉式（synchronized）</td><td>✅</td><td>✅</td><td>⭐⭐</td></tr>
 *   <tr><td>双重检查锁（DCL + volatile）</td><td>✅</td><td>✅</td><td>⭐⭐⭐⭐</td></tr>
 *   <tr><td>静态内部类（Holder）</td><td>✅</td><td>✅</td><td>⭐⭐⭐⭐⭐ 推荐</td></tr>
 *   <tr><td>枚举</td><td>✅</td><td>❌</td><td>⭐⭐⭐⭐⭐ 推荐（天然防反射/序列化）</td></tr>
 * </table>
 *
 * <h2>静态内部类原理（推荐实现）</h2>
 * <p>利用 Java 类加载机制保证线程安全：
 * <ol>
 *   <li>调用 {@code getInstance()} 时，JVM 加载 {@code Singleton} 类</li>
 *   <li>静态内部类 {@code Holder} 在<strong>首次被引用时</strong>才会被加载</li>
 *   <li>类加载过程是线程安全的（JVM 保证），因此 {@code INSTANCE} 的初始化天然线程安全</li>
 *   <li>未被调用时，静态内部类不会被加载 —— 实现懒加载</li>
 * </ol>
 *
 * <h2>注意事项</h2>
 * <ul>
 *   <li>反射可以破坏单例（通过反射调用私有构造函数）—— 枚举可以防御</li>
 *   <li>序列化/反序列化会创建新对象 —— 需实现 {@code readResolve()} 或使用枚举</li>
 *   <li>不要滥用单例 —— 单例本质是全局变量，增加模块间隐式耦合</li>
 * </ul>
 *
 * @see patterns.creational.singleton 各实现方式示例
 */
package patterns.creational.singleton;
