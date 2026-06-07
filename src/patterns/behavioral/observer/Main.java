package patterns.behavioral.observer;

/**
 * 观察者模式演示 — 股票价格监控。
 *
 * <h2>演示场景</h2>
 * <p>多个观察者（手机App、桌面客户端、短信提醒）关注同一只股票的价格变化。
 * 当股票价格更新时，所有观察者各自做出不同的响应。</p>
 *
 * <h2>设计修复说明</h2>
 * <p>本实现修复了原代码中 {@code observer()} 方法名不符合 Java 命名规范的问题。
 * 统一使用 {@link StockPriceSubject#registerObserver(StockObserver)} 作为注册方法名，
 * 符合 Java 中"register" + "Observer" 的常见命名惯例（如 JDK 的 Observable）。</p>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 观察者模式演示：股票价格监控 ==========");
        System.out.println();

        // ==================== 创建被观察的股票 ====================
        StockPriceSubject techStock = new StockPriceSubject("科技龙头股", 150.0);

        // ==================== 创建观察者 ====================
        StockObserver mobileApp = new MobileAppObserver("华泰证券App");
        StockObserver desktopApp = new DesktopAppObserver("同花顺客户端");
        StockObserver smsAlert = new SMSAlertObserver("138-0000-1234", 200.0);

        // ==================== 注册观察者 ====================
        System.out.println("===== 注册观察者 =====");
        techStock.registerObserver(mobileApp);
        techStock.registerObserver(desktopApp);
        techStock.registerObserver(smsAlert);
        System.out.println();

        // ==================== 股票价格上涨 ====================
        System.out.println("===== 股票价格上涨至 180 元 =====");
        techStock.setPrice(180.0);
        System.out.println();

        // ==================== 股票价格继续上涨 ====================
        System.out.println("===== 股票价格上涨至 210 元（超过短信阈值）=====");
        techStock.setPrice(210.0);
        System.out.println();

        // ==================== 股票价格下跌 ====================
        System.out.println("===== 股票价格下跌至 160 元 =====");
        techStock.setPrice(160.0);
        System.out.println();

        // ==================== 移除短信提醒观察者 ====================
        System.out.println("===== 移除短信提醒观察者 =====");
        techStock.removeObserver(smsAlert);
        System.out.println();

        // ==================== 再次更新价格，短信不再收到通知 ====================
        System.out.println("===== 股票价格上涨至 220 元（短信已注销，不会收到通知）=====");
        techStock.setPrice(220.0);
        System.out.println();

        System.out.println("========== 观察者模式演示结束 ==========");
    }
}
