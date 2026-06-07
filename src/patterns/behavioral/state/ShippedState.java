package patterns.behavioral.state;

/**
 * 已发货状态（ShippedState）— 订单已发货等待签收的状态。
 *
 * <h2>允许的操作</h2>
 * <ul>
 *   <li>{@link #deliver(OrderContext)} — 可以签收，签收后切换到已签收状态</li>
 * </ul>
 *
 * <h2>不允许的操作</h2>
 * <ul>
 *   <li>支付 — 订单已支付，不能重复支付</li>
 *   <li>发货 — 订单已发货，不能重复发货</li>
 *   <li>取消 — 订单已发货，取消流程复杂，暂不支持</li>
 * </ul>
 *
 */
public class ShippedState implements OrderState {

    /**
     * 支付订单 — 非法操作。
     *
     * @param context 订单上下文
     */
    @Override
    public void pay(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单已发货，无需再次支付。");
    }

    /**
     * 发货 — 非法操作。
     *
     * <p>订单已发货，不能重复发货。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void ship(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单已发货，请勿重复发货。");
    }

    /**
     * 签收 — 合法操作。
     *
     * <p>订单从"已发货"状态切换到"已签收"状态。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void deliver(OrderContext context) {
        System.out.println("  ✅ 签收成功！订单已进入【已签收】状态。");
        context.setState(new DeliveredState());
    }

    /**
     * 取消订单 — 非法操作。
     *
     * <p>订单已发货，取消流程复杂（需要拦截物流），暂不支持在线取消。
     * 请联系客服处理。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void cancel(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单已发货，取消需要拦截物流，请联系客服处理。");
    }
}
