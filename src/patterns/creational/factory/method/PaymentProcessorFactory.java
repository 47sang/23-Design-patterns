package patterns.creational.factory.method;

/**
 * 抽象工厂 — 支付处理器工厂
 *
 * <h2>模式角色</h2>
 * <p>工厂方法模式的核心抽象：声明工厂方法 {@link #createProcessor()}，
 * 但不实现具体创建逻辑。具体创建逻辑由子类完成。
 * 客户端只依赖此抽象工厂接口，不关心具体工厂的实现。</p>
 *
 * <h2>🎯 与简单工厂的关键区别</h2>
 * <table>
 *   <tr>
 *     <th>对比维度</th>
 *     <th>简单工厂</th>
 *     <th>工厂方法</th>
 *   </tr>
 *   <tr>
 *     <td>新增产品时</td>
 *     <td>修改工厂类（违反开闭原则）</td>
 *     <td>新增工厂子类（符合开闭原则）</td>
 *   </tr>
 *   <tr>
 *     <td>工厂类数量</td>
 *     <td>1 个（包含所有逻辑）</td>
 *     <td>1 个抽象 + N 个具体</td>
 *   </tr>
 *   <tr>
 *     <td>客户端依赖</td>
 *     <td>依赖具体工厂类</td>
 *     <td>依赖抽象工厂接口</td>
 *   </tr>
 * </table>
 *
 * @see AlipayFactory 具体工厂：支付宝
 * @see WechatPayFactory 具体工厂：微信支付
 */
public abstract class PaymentProcessorFactory {

    /**
     * 工厂方法 — 子类必须实现此方法来创建具体的支付处理器
     *
     * <p>此方法声明了"创建产品"的接口，但不指定具体创建哪个产品。
     * 每个具体工厂子类各自实现此方法，返回对应的 {@link PaymentProcessor}。</p>
     *
     * @return 具体支付处理器实例
     */
    protected abstract PaymentProcessor createProcessor();

    /**
     * 模板方法 — 执行支付（客户端直接调用此方法）
     *
     * <p>此方法封装了支付流程的通用步骤，内部调用 {@link #createProcessor()}
     * 获取具体处理器。客户端不需要知道具体使用哪种支付渠道。</p>
     *
     * @param orderId 订单号
     * @param amount  支付金额
     * @return 支付结果描述
     */
    public final String processPayment(String orderId, double amount) {
        PaymentProcessor processor = createProcessor();
        return processor.pay(orderId, amount);
    }

    /**
     * 模板方法 — 查询退款（客户端直接调用此方法）
     */
    public final String queryRefund(String orderId, String refundId) {
        PaymentProcessor processor = createProcessor();
        return processor.queryRefund(orderId, refundId);
    }
}
