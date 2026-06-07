package patterns.creational.factory.simple;

/**
 * 抽象产品 — 日志记录器接口
 *
 * <p>定义所有日志记录器共有的行为契约。
 * 简单工厂模式中，客户端代码只依赖此抽象接口，
 * 不关心具体使用文件、控制台还是数据库存储日志。</p>
 *
 */
public interface Logger {

    /**
     * 记录一条日志消息
     *
     * @param message 日志内容，不允许为 {@code null} 或空字符串
     * @throws IllegalArgumentException 当 message 为 {@code null} 或空白时抛出
     */
    void log(String message);
}
