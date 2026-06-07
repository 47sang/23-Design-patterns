package patterns.behavioral.observer;

/**
 * 手机App观察者（MobileAppObserver）— 观察者模式中的具体观察者。
 *
 * <p>模拟手机端的股票监控应用，当关注的股票价格变化时，
 * 收到推送通知并更新本地显示。</p>
 *
 */
public class MobileAppObserver implements StockObserver {

    /** App 名称 */
    private final String appName;

    /**
     * 构造一个手机App观察者。
     *
     * @param appName App 的名称
     */
    public MobileAppObserver(String appName) {
        this.appName = appName;
    }

    /**
     * 收到股票价格更新通知。
     *
     * <p>手机App 收到推送后，在本地更新股票价格显示，
     * 如果价格波动较大还会触发震动提醒。</p>
     *
     * @param stockName 股票名称
     * @param price     最新价格
     */
    @Override
    public void update(String stockName, double price) {
        System.out.println("  📱 [" + appName + "] 收到推送："
            + stockName + " 当前价格 " + String.format("%.2f", price)
            + " 元，已更新本地显示。");
    }

    @Override
    public String toString() {
        return appName;
    }
}
