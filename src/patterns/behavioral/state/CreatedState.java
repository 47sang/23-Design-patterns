package patterns.behavioral.state;

/**
 * 已创建状态（CreatedState）— 订单刚创建时的状态。
 *
 * <h2>允许的操作</h2>
 * <ul>
 *   <li>{@link #pay(OrderContext)} — 可以支付，支付后切换到已支付状态</li>
 * </ul>
 *
 * <h2>不允许的操作</h2>
 * <ul>
 *   <li>发货 — 订单未支付，不能发货</li>
 *   <li>签收 — 订单未发货，不能签收</li>
 *   <li>取消 — 刚创建的订单通常不允许直接取消（此处设计为不允许）</li>
 * </ul>
 *
 */
public class CreatedState implements OrderState {

    /**
     * 支付订单 — 合法操作。
     *
     * <p>订单从"已创建"状态切换到"已支付"状态。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void pay(OrderContext context) {
        System.out.println("  ✅ 支付成功！订单已进入【已支付】状态。");
        context.setState(new PaidState());
    }

    /**
     * 发货 — 非法操作。
     *
     * <p>订单尚未支付，无法发货。提示用户先完成支付。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void ship(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单尚未支付，请先完成支付后再发货。");
    }

    /**
     * 签收 — 非法操作。
     *
     * @param context 订单上下文
     */
    @Override
    public void deliver(OrderContext context) {
        System.out.println("  ❌ 操作失败：订单尚未发货，无法签收。");
    }

    /**
     * 取消订单 — 非法操作。
     *
     * <p>刚创建的订单暂不支持取消操作。</p>
     *
     * @param context 订单上下文
     */
    @Override
    public void cancel(OrderContext context) {
        System.out.println("  ❌ 操作失败：新创建的订单暂不支持取消，请联系客服。");
    }
}
