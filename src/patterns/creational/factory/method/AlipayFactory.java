package patterns.creational.factory.method;

/**
 * 具体工厂 — 支付宝支付处理器工厂
 *
 * <p>实现抽象工厂 {@link PaymentProcessorFactory}，
 * 负责创建 {@link AlipayProcessor} 实例。
 *
 * <p>🎯 新增支付方式时，只需新增一个类似此类的工厂子类，
 * 完全不需要修改已有代码——符合<strong>开闭原则</strong>。</p>
 *
 */
public class AlipayFactory extends PaymentProcessorFactory {

    @Override
    protected PaymentProcessor createProcessor() {
        return new AlipayProcessor();
    }
}
