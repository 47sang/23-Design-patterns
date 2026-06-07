package patterns.creational.factory.abstract_factory;

/**
 * 抽象产品 — 平板电脑
 *
 * <p>定义所有平板共有的行为契约。
 * 与 {@link Phone}、{@link Earbuds} 共同构成一个完整的产品族。</p>
 *
 */
public interface Tablet {

    /**
     * 获取平板品牌名称
     */
    String getBrand();

    /**
     * 获取平板型号
     */
    String getModel();

    /**
     * 获取平板价格（元）
     */
    double getPrice();

    /**
     * 打印平板信息
     */
    void printInfo();
}
