package patterns.structural.adapter;

import java.math.BigDecimal;

/**
 * 对象适配器（Object Adapter）—— 推荐实现
 *
 * <p>通过<strong>组合</strong>被适配者 {@link PaymentSDK}（持有其引用），
 * 同时<strong>实现</strong>目标接口 {@link PaymentTarget}，
 * 将第三方 SDK 的接口转换为系统需要的接口。</p>
 *
 * <h2>为什么推荐对象适配器？</h2>
 * <ul>
 *   <li><strong>符合"组合优于继承"原则</strong>：不破坏被适配者的封装</li>
 *   <li><strong>可以适配多个被适配者</strong>：一个适配器可以组合多个 Adaptee</li>
 *   <li><strong>不受 Java 单继承限制</strong>：即使 Adaptee 是 final 也能适配</li>
 *   <li><strong>更灵活</strong>：可以在运行时动态更换被适配者</li>
 * </ul>
 *
 * <h2>与类适配器的核心区别</h2>
 * <p>类适配器通过"继承"获得被适配者的能力，
 * 对象适配器通过"组合"（持有引用）获得被适配者的能力。
 * 组合比继承更灵活，是面向对象设计的首选方式。</p>
 *
 * @see ClassAdapter 类适配器实现
 */
class ObjectAdapter implements PaymentTarget {

    /**
     * 持有被适配者对象的引用（组合关系）。
     *
     * <p>通过这个引用，适配器可以委托被适配者完成实际工作，
     * 同时在前/后添加自己的转换逻辑。</p>
     */
    private final PaymentSDK paymentSDK;

    /**
     * 构造器：传入需要适配的第三方 SDK 实例。
     *
     * @param paymentSDK 被适配的第三方支付 SDK 实例
     */
    ObjectAdapter(PaymentSDK paymentSDK) {
        this.paymentSDK = paymentSDK;
    }

    /**
     * 将目标接口的 {@code pay(BigDecimal)} 转换为被适配者的 {@code doPay(double)}。
     *
     * <p>通过组合持有的 PaymentSDK 引用，调用其 doPay 方法，
     * 同时实现了 PaymentTarget 接口，满足客户端对目标接口的调用。</p>
     *
     * @param amount 支付金额（BigDecimal），在此方法中转换为 double 后传递给第三方 SDK
     */
    @Override
    public void pay(BigDecimal amount) {
        // BigDecimal → double 转换，适配第三方 SDK 的参数类型
        double amountDouble = amount.doubleValue();
        // 委托给持有的 PaymentSDK 实例执行实际支付
        paymentSDK.doPay(amountDouble);
    }
}
