package patterns.creational.factory.method;

/**
 * 抽象产品 — 支付处理器接口
 *
 * <p>定义所有支付方式共有的操作契约。
 * 在工厂方法模式中，客户端代码只依赖此抽象接口，
 * 不关心具体是支付宝、微信还是其他支付渠道。</p>
 *
 */
public interface PaymentProcessor {

    /**
     * 执行支付操作
     *
     * @param orderId   订单号，不允许为 {@code null} 或空字符串
     * @param amount    支付金额，必须大于 0
     * @return 支付结果描述
     * @throws IllegalArgumentException 当参数不合法时抛出
     */
    String pay(String orderId, double amount);

    /**
     * 查询退款状态
     *
     * @param orderId   订单号
     * @param refundId  退款单号
     * @return 退款状态描述
     */
    String queryRefund(String orderId, String refundId);
}
