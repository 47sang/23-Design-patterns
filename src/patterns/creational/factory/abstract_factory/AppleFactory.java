package patterns.creational.factory.abstract_factory;

/**
 * 具体工厂 — 苹果电子产品工厂
 *
 * <p>实现 {@link ElectronicsFactory}，负责创建苹果品牌的完整产品族：
 * 苹果手机、苹果平板、苹果无线耳机。
 * 保证所有产品属于同一个"苹果生态"，风格统一。</p>
 *
 */
public class AppleFactory implements ElectronicsFactory {

    @Override
    public Phone createPhone() {
        return new ApplePhone("iPhone 17 Pro", 8999.0);
    }

    @Override
    public Tablet createTablet() {
        return new AppleTablet("iPad Pro M5", 8999.0);
    }

    @Override
    public Earbuds createEarbuds() {
        return new AppleEarbuds("AirPods Pro 4", 1899.0, true);
    }
}
