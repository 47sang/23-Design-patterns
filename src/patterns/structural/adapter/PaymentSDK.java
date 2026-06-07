package patterns.structural.adapter;

/**
 * 第三方支付 SDK（被适配者 / Adaptee）
 *
 * <p>这是一个第三方库提供的支付接口，使用 {@code double} 类型表示金额。
 * 我们无法修改这个类的源代码，但需要将其接入我们的系统。</p>
 *
 * <h2>设计意图</h2>
 * <p>作为适配器模式中的"被适配者"，这个类拥有客户端需要的方法，
 * 但接口签名与目标接口不兼容，因此需要适配器进行转换。</p>
 *
 * <h2>适配器模式中的角色</h2>
 * <ul>
 *   <li><strong>Adaptee（被适配者）</strong>：PaymentSDK</li>
 *   <li><strong>Target（目标接口）</strong>：PaymentTarget</li>
 *   <li><strong>Adapter（适配器）</strong>：ClassAdapter 或 ObjectAdapter</li>
 * </ul>
 *
 */
class PaymentSDK {

    /**
     * 执行支付操作（第三方 SDK 原生的方法签名）。
     *
     * <p>注意：该方法使用 {@code double} 类型，
     * 不适合涉及金额的精确计算（存在浮点精度问题）。
     * 但这是第三方库的接口，我们无法改变它。</p>
     *
     * @param amount 支付金额（使用 double 类型，来自第三方 SDK 接口）
     */
    void doPay(double amount) {
        System.out.println("[PaymentSDK] 第三方 SDK 执行支付，金额：¥" + amount);
    }
}
