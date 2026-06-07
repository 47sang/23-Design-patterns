package patterns.structural.adapter;

import java.math.BigDecimal;

/**
 * 支付目标接口（Target）
 *
 * <p>这是我们系统内部统一使用的支付接口，
 * 使用 {@link BigDecimal} 来表示金额，保证金额计算的精确性。</p>
 *
 * <h2>设计意图</h2>
 * <p>作为适配器模式中的"目标接口"，客户端代码面向此接口编程，
 * 不需要关心底层实际使用的是哪个支付 SDK。</p>
 *
 * <h2>适配器模式中的角色</h2>
 * <ul>
 *   <li><strong>Target（目标接口）</strong>：PaymentTarget（本接口）</li>
 *   <li><strong>Adaptee（被适配者）</strong>：PaymentSDK</li>
 *   <li><strong>Adapter（适配器）</strong>：ClassAdapter 或 ObjectAdapter</li>
 * </ul>
 *
 */
interface PaymentTarget {

    /**
     * 执行支付操作。
     *
     * <p>使用 {@link BigDecimal} 表示金额，避免浮点数精度丢失问题。
     * 适配器负责将 BigDecimal 转换为第三方 SDK 需要的 double 类型。</p>
     *
     * @param amount 支付金额，使用 BigDecimal 保证精度
     */
    void pay(BigDecimal amount);
}
