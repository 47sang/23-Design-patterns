package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 股票价格被观察者（StockPriceSubject）— 观察者模式中的主题角色。
 *
 * <h2>设计意图</h2>
 * <p>维护一个观察者列表，当股票价格变化时，
 * 通知所有已注册的观察者。被观察者不关心观察者是谁，
 * 也不关心观察者如何处理价格变化，只负责"通知"。</p>
 *
 * <h2>核心方法</h2>
 * <ul>
 *   <li>{@link #registerObserver(StockObserver)} — 注册观察者</li>
 *   <li>{@link #removeObserver(StockObserver)} — 移除观察者</li>
 *   <li>{@link #notifyObservers()} — 通知所有观察者</li>
 * </ul>
 *
 * <h2>与 JDK 内置观察者模式的区别</h2>
 * <p>Java 标准库提供了 {@link java.util.Observer} / {@link java.util.Observable}
 * 但 {@code Observable} 是类而非接口，且已被标记为过时（deprecated）。
 * 本实现手动实现了观察者模式，更符合现代 Java 的最佳实践。</p>
 *
 */
public class StockPriceSubject {

    /** 被观察的股票名称 */
    private final String stockName;
    /** 当前股票价格 */
    private double price;
    /** 注册的观察者列表 */
    private final List<StockObserver> observers = new ArrayList<>();

    /**
     * 构造一个股票价格主题。
     *
     * @param stockName 股票名称
     * @param price     初始价格
     */
    public StockPriceSubject(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    /**
     * 注册一个观察者。
     *
     * <p>观察者注册后，当股票价格变化时会收到通知。</p>
     *
     * @param observer 要注册的观察者
     */
    public void registerObserver(StockObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("  [注册] " + observer.getClass().getSimpleName()
                + " 开始关注 " + stockName);
        }
    }

    /**
     * 移除一个观察者。
     *
     * <p>移除后，该观察者不再收到股票价格变化的通知。</p>
     *
     * @param observer 要移除的观察者
     */
    public void removeObserver(StockObserver observer) {
        if (observers.remove(observer)) {
            System.out.println("  [注销] " + observer.getClass().getSimpleName()
                + " 取消关注 " + stockName);
        }
    }

    /**
     * 通知所有观察者 — 价格变化时的核心方法。
     *
     * <p>遍历观察者列表，调用每个观察者的 {@link StockObserver#update(String, double)}
     * 方法，推送当前股票名称和最新价格。</p>
     */
    private void notifyObservers() {
        System.out.println("📢 " + stockName + " 价格更新为 " + price
            + "，通知所有观察者...");
        for (StockObserver observer : observers) {
            observer.update(stockName, price);
        }
    }

    /**
     * 设置股票价格 — 会触发通知。
     *
     * <p>当价格发生变化时，自动调用 {@link #notifyObservers()}
     * 通知所有注册的观察者。</p>
     *
     * @param newPrice 新的股票价格
     */
    public void setPrice(double newPrice) {
        System.out.println("📈 " + stockName + " 价格从 " + price + " 变更为 " + newPrice);
        this.price = newPrice;
        notifyObservers();
    }

    /** @return 股票名称 */
    public String getStockName() {
        return stockName;
    }

    /** @return 当前价格 */
    public double getPrice() {
        return price;
    }
}
