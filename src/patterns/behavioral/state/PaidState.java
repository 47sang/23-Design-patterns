package patterns.behavioral.state;

/**
 * 已支付状态（PaidState）— 订单完成支付后的状态。
 *
 * <h2>允许的操作</h2>
 * <ul>
 *   <li>{@link #ship(OrderContext)} — 可以发货，发货后切换到已发货状态</li>
 *   <li>{@link #cancel(OrderContext)} — 可以取消，取消后订单关闭</li>
 * </ul>
 *
 * <h2>不允许的操作</h2>
 * <ul>
 *   <li>支付 — 订单已支付，不能重复支付</li>
 *   <li>签收 — 订单未发货，不能签收</li>
 * </ul>
 *
 */
public class PaidState implements OrderState {

    /**
     * 支付订单 — 非法操作。
     *
     * <p>订单已支付，不能重复支付。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void pay(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单已支付，请勿重复支付。");
    }

    /**
     * 发货 — 合法操作。
     *
     * <p>订单从"已支付"状态切换到"已发货"状态。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void ship(OrderContext context) {
        System.out.println("  ✅ 发货成功！订单已进入【已发货】状态。");
        context.setState(new ShippedState());
    }

    /**
     * 签收 — 非法操作。
     *
     * <p>订单尚未发货，无法签收。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void deliver(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单尚未发货，请等待发货后再签收。");
    }

    /**
     * 取消订单 — 合法操作。
     *
     * <p>已支付的订单可以取消，退款流程将自动发起。
     * 本演示中取消后状态保持不变（实际项目中应切换到"已取消"状态）。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void cancel(OrderContext context) {
        System.out.println("  ✅ 取消成功！订单已取消，退款将在1-3个工作日内退回。");
        // 实际项目中这里应该切换到 CancelledState
        // 为简化演示，取消后仍保持原状态
    }
}
