package patterns.creational.factory.simple;

/**
 * 工厂类 — 日志记录器工厂（简单工厂）
 *
 * <h2>模式角色</h2>
 * <p>简单工厂模式的核心：根据传入的类型字符串，决定创建哪种具体产品。
 * 客户端只需调用 {@link #getLogger(String)}，无需了解 {@link FileLogger}
 * 和 {@link ConsoleLogger} 的存在。</p>
 *
 * <h2>⚠️ 违反开闭原则</h2>
 * <p>当需要新增一种日志记录器（如数据库日志）时，必须：</p>
 * <ol>
 *   <li>新增 {@link DatabaseLogger} 类</li>
 *   <li>修改本类的 {@link #getLogger(String)} 方法，添加新的 {@code case}</li>
 * </ol>
 * <p>这就违反了<strong>开闭原则</strong>（对扩展开放，对修改关闭）。
 * 工厂方法模式和抽象工厂模式就是为了解决这个问题而设计的。</p>
 *
 * <h2>适用场景</h2>
 * <ul>
 *   <li>产品种类较少且不经常变化的场景</li>
 *   <li>客户端只需要知道传入参数，不关心创建细节</li>
 * </ul>
 *
 * @see Logger 抽象产品
 * @see FileLogger 具体产品：文件日志
 * @see ConsoleLogger 具体产品：控制台日志
 */
public class LoggerFactory {

    /**
     * 根据类型字符串创建对应的日志记录器
     *
     * <h2>参数说明</h2>
     * <ul>
     *   <li>{@code "file"} — 创建 {@link FileLogger}，需配合文件路径</li>
     *   <li>{@code "console"} — 创建 {@link ConsoleLogger}</li>
     * </ul>
     *
     * @param type 日志类型，支持 "file" 和 "console"
     * @return 对应类型的 {@link Logger} 实例
     * @throws IllegalArgumentException 当 type 不支持时抛出
     */
    public static Logger getLogger(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("日志类型不能为空");
        }

        return switch (type.toLowerCase().trim()) {
            case "file" -> new FileLogger("application.log");
            case "console" -> new ConsoleLogger();
            default -> throw new IllegalArgumentException(
                    "不支持的日志类型: " + type + "，支持的类型: file, console");
        };
    }
}
