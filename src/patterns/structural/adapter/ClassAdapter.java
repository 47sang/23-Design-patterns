package patterns.structural.adapter;

import java.math.BigDecimal;

/**
 * 类适配器（Class Adapter）
 *
 * <p>通过<strong>继承</strong>被适配者 {@link PaymentSDK}，
 * 同时<strong>实现</strong>目标接口 {@link PaymentTarget}，
 * 将第三方 SDK 的接口转换为系统需要的接口。</p>
 *
 * <h2>类适配器 vs 对象适配器</h2>
 * <table>
 *   <tr>
 *     <th>对比维度</th>
 *     <th>类适配器</th>
 *     <th>对象适配器</th>
 *   </tr>
 *   <tr>
 *     <td>实现方式</td>
 *     <td>继承 Adaptee + 实现 Target</td>
 *     <td>组合 Adaptee（持有引用）+ 实现 Target</td>
 *   </tr>
 *   <tr>
 *     <td>灵活性</td>
 *     <td>较低，只能适配一个 Adaptee 类</td>
 *     <td>较高，可以同时适配多个 Adaptee</td>
 *   </tr>
 *   <tr>
 *     <td>Java 限制</td>
 *     <td>Java 不支持多继承，如果 Adaptee 是 final 则无法使用</td>
 *     <td>无此限制</td>
 *   </tr>
 *   <tr>
 *     <td>推荐场景</td>
 *     <td>Adaptee 接口简单、稳定，不需要扩展其行为</td>
 *     <td>大多数场景，更符合"组合优于继承"原则</td>
 *   </tr>
 * </table>
 *
 * <h2>适用场景</h2>
 * <p>当被适配者（Adaptee）的接口稳定、不需要扩展其行为时，
 * 类适配器是一个简洁的选择。但在 Java 中，由于不支持多继承，
 * 类适配器的适用场景有限，<strong>对象适配器通常是更好的选择</strong>。</p>
 *
 * @see ObjectAdapter 对象适配器实现
 */
class ClassAdapter extends PaymentSDK implements PaymentTarget {

    /**
     * 将目标接口的 {@code pay(BigDecimal)} 转换为被适配者的 {@code doPay(double)}。
     *
     * <p>通过继承 PaymentSDK，直接调用父类的 {@code doPay} 方法，
     * 同时实现了 PaymentTarget 接口，满足客户端对目标接口的调用。</p>
     *
     * @param amount 支付金额（BigDecimal），在此方法中转换为 double 后传递给第三方 SDK
     */
    @Override
    public void pay(BigDecimal amount) {
        // BigDecimal → double 转换，适配第三方 SDK 的参数类型
        double amountDouble = amount.doubleValue();
        // 调用继承自父类 PaymentSDK 的 doPay 方法
        doPay(amountDouble);
    }
}
