package patterns.creational.factory.method;

/**
 * 具体产品 — 支付宝支付处理器
 *
 * <p>封装支付宝支付渠道的具体业务逻辑。
 * 在工厂方法模式中，此类由 {@link AlipayFactory} 创建，
 * 客户端不直接实例化此类。</p>
 *
 */
public class AlipayProcessor implements PaymentProcessor {

    @Override
    public String pay(String orderId, double amount) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("订单号不能为空");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("支付金额必须大于0");
        }
        return "支付宝支付成功 | 订单: " + orderId + " | 金额: ¥" + amount;
    }

    @Override
    public String queryRefund(String orderId, String refundId) {
        return "支付宝退款查询 | 订单: " + orderId + " | 退款单: " + refundId + " | 状态: 退款中";
    }
}
