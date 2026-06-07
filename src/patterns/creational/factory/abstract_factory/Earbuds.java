package patterns.creational.factory.abstract_factory;

/**
 * 抽象产品 — 无线耳机
 *
 * <p>定义所有无线耳机共有的行为契约。
 * 与 {@link Phone}、{@link Tablet} 共同构成一个完整的产品族。</p>
 *
 */
public interface Earbuds {

    /**
     * 获取耳机品牌名称
     */
    String getBrand();

    /**
     * 获取耳机型号
     */
    String getModel();

    /**
     * 获取耳机价格（元）
     */
    double getPrice();

    /**
     * 是否支持主动降噪
     */
    boolean hasActiveNoiseCancellation();

    /**
     * 打印耳机信息
     */
    void printInfo();
}
