package patterns.behavioral.state;

/**
 * 订单状态接口（OrderState）— 状态模式中的抽象状态。
 *
 * <h2>设计意图</h2>
 * <p>订单在不同阶段有不同的行为。例如：已创建的订单只能支付，
 * 已支付的订单可以发货或取消，已发货的订单只能签收。
 * 状态模式将每种状态的行为封装到独立的状态类中，
 * 避免了在上下文中使用大量的条件判断（if-else / switch）。</p>
 *
 * <h2>核心方法</h2>
 * <p>每个状态类实现以下方法，定义在当前状态下允许的操作：</p>
 * <ul>
 *   <li>{@link #pay(OrderContext)} — 支付操作</li>
 *   <li>{@link #ship(OrderContext)} — 发货操作</li>
 *   <li>{@link #deliver(OrderContext)} — 签收操作</li>
 *   <li>{@link #cancel(OrderContext)} — 取消操作</li>
 * </ul>
 *
 * <h2>具体状态类</h2>
 * <ul>
 *   <li>{@link CreatedState} — 已创建，只能支付</li>
 *   <li>{@link PaidState} — 已支付，可以发货或取消</li>
 *   <li>{@link ShippedState} — 已发货，可以签收</li>
 *   <li>{@link DeliveredState} — 已签收，最终状态</li>
 * </ul>
 *
 * <h2>状态转换</h2>
 * <p>状态转换由具体状态类在处理方法中自行控制。
 * 当一个操作被合法执行后，状态类会调用
 * {@link OrderContext#setState(OrderState)} 切换状态。</p>
 *
 */
public interface OrderState {

    /**
     * 支付订单。
     *
     * <p>不同状态下支付操作的合法性不同。
     * 例如：已创建的订单可以支付，已支付的订单不能重复支付。</p>
     *
     * @param context 订单上下文
     */
    void pay(OrderContext context);

    /**
     * 发货。
     *
     * @param context 订单上下文
     */
    void ship(OrderContext context);

    /**
     * 签收。
     *
     * @param context 订单上下文
     */
    void deliver(OrderContext context);

    /**
     * 取消订单。
     *
     * @param context 订单上下文
     */
    void cancel(OrderContext context);
}
