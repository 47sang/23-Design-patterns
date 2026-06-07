package patterns.behavioral.observer;

/**
 * 短信提醒观察者（SMSAlertObserver）— 观察者模式中的具体观察者。
 *
 * <p>模拟短信提醒服务，当关注的股票价格变化时，
 * 判断是否满足预设的价格阈值条件，如果满足则发送短信提醒。</p>
 *
 * <h2>设计说明</h2>
 * <p>短信提醒服务通常只在价格达到某个关键阈值时才真正发送短信，
 * 避免对用户造成过多打扰。本实现中，当价格 ≥ 200 时触发短信提醒。</p>
 *
 */
public class SMSAlertObserver implements StockObserver {

    /** 短信接收人 */
    private final String phoneNumber;
    /** 价格提醒阈值 */
    private final double threshold;

    /**
     * 构造一个短信提醒观察者。
     *
     * @param phoneNumber 接收短信的手机号
     * @param threshold   触发提醒的价格阈值
     */
    public SMSAlertObserver(String phoneNumber, double threshold) {
        this.phoneNumber = phoneNumber;
        this.threshold = threshold;
    }

    /**
     * 收到股票价格更新通知。
     *
     * <p>判断当前价格是否达到预设阈值，如果达到则发送短信提醒。</p>
     *
     * @param stockName 股票名称
     * @param price     最新价格
     */
    @Override
    public void update(String stockName, double price) {
        if (price >= threshold) {
            System.out.println("  📲 [短信提醒] 向 " + phoneNumber + " 发送短信："
                + stockName + " 当前价格 " + String.format("%.2f", price)
                + " 元，已超过您设定的阈值 " + threshold + " 元！");
        } else {
            System.out.println("  📲 [短信提醒] " + stockName + " 价格 "
                + String.format("%.2f", price) + " 元，未达到阈值 "
                + threshold + " 元，不发送短信。");
        }
    }

    @Override
    public String toString() {
        return "短信提醒(" + phoneNumber + ")";
    }
}
