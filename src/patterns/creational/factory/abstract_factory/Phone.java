package patterns.creational.factory.abstract_factory;

/**
 * 抽象产品 — 手机
 *
 * <p>定义所有手机共有的行为契约。
 * 抽象工厂模式中，同一个工厂创建的 Phone、Tablet、Earbuds
 * 属于同一个"产品族"，风格一致（如小米全家桶或苹果全家桶）。</p>
 *
 */
public interface Phone {

    /**
     * 获取手机品牌名称
     */
    String getBrand();

    /**
     * 获取手机型号
     */
    String getModel();

    /**
     * 获取手机价格（元）
     */
    double getPrice();

    /**
     * 打印手机信息
     */
    void printInfo();
}
