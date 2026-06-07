package patterns.creational.factory.abstract_factory;

/**
 * 具体工厂 — 小米电子产品工厂
 *
 * <p>实现 {@link ElectronicsFactory}，负责创建小米品牌的完整产品族：
 * 小米手机、小米平板、小米无线耳机。
 * 保证所有产品属于同一个"小米生态"，风格统一。</p>
 *
 */
public class XiaomiFactory implements ElectronicsFactory {

    @Override
    public Phone createPhone() {
        return new XiaomiPhone("Xiaomi 15 Pro", 4999.0);
    }

    @Override
    public Tablet createTablet() {
        return new XiaomiTablet("Xiaomi Pad 7 Pro", 2999.0);
    }

    @Override
    public Earbuds createEarbuds() {
        return new XiaomiEarbuds("Buds 5 Pro", 499.0, true);
    }
}
