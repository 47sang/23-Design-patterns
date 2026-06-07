package patterns.creational.factory.simple;

/**
 * 具体产品 — 控制台日志记录器
 *
 * <p>将日志输出到标准输出（控制台），适用于开发调试和运维排查场景。
 * 演示简单工厂模式中"具体产品"的角色。</p>
 *
 */
public class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("日志内容不能为空");
        }
        System.out.println("[控制台日志] " + message);
    }
}
