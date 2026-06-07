package patterns.behavioral.observer;

/**
 * 桌面客户端观察者（DesktopAppObserver）— 观察者模式中的具体观察者。
 *
 * <p>模拟桌面端的股票监控应用，当关注的股票价格变化时，
 * 收到通知并更新K线图表和实时报价面板。</p>
 *
 */
public class DesktopAppObserver implements StockObserver {

    /** 客户端名称 */
    private final String clientName;

    /**
     * 构造一个桌面客户端观察者。
     *
     * @param clientName 客户端名称
     */
    public DesktopAppObserver(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 收到股票价格更新通知。
     *
     * <p>桌面客户端收到通知后，更新K线图表的最新数据点，
     * 并在报价面板上高亮显示价格变化。</p>
     *
     * @param stockName 股票名称
     * @param price     最新价格
     */
    @Override
    public void update(String stockName, double price) {
        System.out.println("  🖥️  [" + clientName + "] 收到通知："
            + stockName + " 当前价格 " + String.format("%.2f", price)
            + " 元，K线图表已更新。");
    }

    @Override
    public String toString() {
        return clientName;
    }
}
