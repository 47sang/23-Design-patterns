package patterns.creational.factory.abstract_factory;

/**
 * 抽象工厂 — 电子产品工厂
 *
 * <h2>模式角色</h2>
 * <p>抽象工厂模式的核心：声明创建一系列相关产品（Phone、Tablet、Earbuds）的接口。
 * 每个具体工厂负责创建一个完整的"产品族"——同一品牌下的手机、平板、耳机，
 * 保证所有产品风格一致、生态互通。</p>
 *
 * <h2>🎯 产品族概念</h2>
 * <p>同一工厂（如 {@link XiaomiFactory}）创建的所有产品属于同一个产品族：</p>
 * <ul>
 *   <li>小米手机 + 小米平板 + 小米耳机 → 小米生态，协同工作</li>
 *     <li>苹果手机 + 苹果平板 + 苹果耳机 → 苹果生态，协同工作</li>
 * </ul>
 * <p>如果混用不同工厂的产品（小米手机 + 苹果耳机），可能导致生态不兼容。</p>
 *
 * <h2>与工厂方法的区别</h2>
 * <ul>
 *   <li>工厂方法：一个工厂创建<strong>一种</strong>产品</li>
 *   <li>抽象工厂：一个工厂创建<strong>一族</strong>产品</li>
 * </ul>
 *
 * @see XiaomiFactory 具体工厂：小米电子产品
 * @see AppleFactory 具体工厂：苹果电子产品
 */
public interface ElectronicsFactory {

    /**
     * 创建一部手机
     *
     * @return 手机实例
     */
    Phone createPhone();

    /**
     * 创建一台平板
     *
     * @return 平板实例
     */
    Tablet createTablet();

    /**
     * 创建一副无线耳机
     *
     * @return 耳机实例
     */
    Earbuds createEarbuds();
}
