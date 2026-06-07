package patterns.behavioral.state;

/**
 * 已签收状态（DeliveredState）— 订单的最终状态。
 *
 * <h2>设计意图</h2>
 * <p>已签收是订单生命周期的终点，此状态下所有操作都被视为非法。
 * 这样可以防止对已完成订单的误操作，保证数据的一致性。</p>
 *
 * <h2>不允许的操作</h2>
 * <ul>
 *   <li>支付 — 订单已完成，不能重复支付</li>
 *   <li>发货 — 订单已完成，不能重复发货</li>
 *   <li>签收 — 订单已签收，不能重复签收</li>
 *   <li>取消 — 订单已完成，不能取消</li>
 * </ul>
 *
 */
public class DeliveredState implements OrderState {

    /**
     * 支付订单 — 非法操作。
     *
     * @param context 订单上下文
     */
    @Override
    public void pay(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单已完成，无法再次支付。");
    }

    /**
     * 发货 — 非法操作。
     *
     * @param context 订单上下文
     */
    @Override
    public void ship(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单已完成，无法再次发货。");
    }

    /**
     * 签收 — 非法操作。
     *
     * <p>订单已签收，不能重复签收。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void deliver(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单已签收完成，请勿重复操作。");
    }

    /**
     * 取消订单 — 非法操作。
     *
     * <p>订单已完成，无法取消。如需退货请走售后流程。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void cancel(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单已完成，无法取消。如需退货请走售后流程。");
    }
}
