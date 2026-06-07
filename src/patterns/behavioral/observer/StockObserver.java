package patterns.behavioral.observer;

/**
 * 股票观察者接口（StockObserver）— 观察者模式中的观察者角色。
 *
 * <h2>设计意图</h2>
 * <p>定义观察者的统一接口。当股票价格发生变化时，
 * 被观察者会调用所有已注册观察者的 {@link #update(String, double)} 方法，
 * 将股票名称和新价格推送给观察者。</p>
 *
 * <h2>推模型 vs 拉模型</h2>
 * <p>本实现采用推模型（Push Model）：被观察者主动将股票名称和价格
 * 作为参数传递给观察者。观察者不需要再去查询被观察者获取数据，
 * 减少了观察者的工作。但缺点是如果观察者需要更多信息，
 * 被观察者接口需要频繁修改。</p>
 *
 * <h2>具体观察者</h2>
 * <ul>
 *   <li>{@link MobileAppObserver} — 手机App，价格变化时推送通知</li>
 *   <li>{@link DesktopAppObserver} — 桌面客户端，价格变化时更新图表</li>
 *   <li>{@link SMSAlertObserver} — 短信提醒，价格超过阈值时发送短信</li>
 * </ul>
 *
 */
public interface StockObserver {

    /**
     * 股票价格更新回调。
     *
     * <p>当被观察的股票价格发生变化时，此方法会被调用。</p>
     *
     * @param stockName 股票名称
     * @param price     最新价格
     */
    void update(String stockName, double price);
}
