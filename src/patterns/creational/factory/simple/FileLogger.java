package patterns.creational.factory.simple;

/**
 * 具体产品 — 文件日志记录器
 *
 * <p>将日志写入到指定文件中。每次调用 {@link #log(String)} 都会追加一行到日志文件。
 * 演示简单工厂模式中"具体产品"的角色：客户端不直接实例化此类，
 * 而是通过 {@link LoggerFactory} 获取。</p>
 *
 */
public class FileLogger implements Logger {

    private final String filePath;

    /**
     * 构造一个文件日志记录器
     *
     * @param filePath 日志文件的存储路径，不允许为 {@code null} 或空字符串
     */
    public FileLogger(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("日志文件路径不能为空");
        }
        this.filePath = filePath;
    }

    @Override
    public void log(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("日志内容不能为空");
        }
        // 实际项目中这里会使用 java.nio.file.Files 写入文件
        // 演示目的仅打印输出
        System.out.println("[文件日志 → " + filePath + "] " + message);
    }
}
