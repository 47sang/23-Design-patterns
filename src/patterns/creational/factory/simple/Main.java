package patterns.creational.factory.simple;

/**
 * 简单工厂模式演示入口
 *
 * <h2>演示内容</h2>
 * <ol>
 *   <li>通过 {@link LoggerFactory#getLogger(String)} 创建不同日志记录器</li>
 *   <li>客户端只依赖 {@link Logger} 接口，不感知具体实现类</li>
 *   <li>展示简单工厂的便利性，以及新增产品时的代码侵入</li>
 * </ol>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== 简单工厂模式演示 =====");
        System.out.println();

        // 1. 获取控制台日志记录器
        System.out.println("--- 控制台日志记录器 ---");
        Logger consoleLogger = LoggerFactory.getLogger("console");
        consoleLogger.log("这是一条控制台日志");
        System.out.println();

        // 2. 获取文件日志记录器
        System.out.println("--- 文件日志记录器 ---");
        Logger fileLogger = LoggerFactory.getLogger("file");
        fileLogger.log("这是一条文件日志");
        System.out.println();

        // 3. 演示：新增日志类型需要修改工厂类（违反开闭原则）
        System.out.println("--- 违反开闭原则的体现 ---");
        System.out.println("如果需要新增 'database' 类型的日志记录器，");
        System.out.println("必须修改 LoggerFactory.getLogger() 方法，添加新的 case 分支。");
        System.out.println("这就是简单工厂的主要缺点。");
        System.out.println();

        try {
            LoggerFactory.getLogger("database");
        } catch (IllegalArgumentException e) {
            System.out.println("捕获预期异常: " + e.getMessage());
        }
    }
}
