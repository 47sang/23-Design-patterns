package patterns.behavioral.state;

/**
 * 订单上下文（OrderContext）— 状态模式中的上下文对象。
 *
 * <h2>设计意图</h2>
 * <p>上下文持有当前状态（{@link OrderState}），
 * 并将客户端请求委托给当前状态对象处理。
 * 上下文本身不包含状态相关的业务逻辑，
 * 所有行为由当前状态对象决定。</p>
 *
 * <h2>核心机制</h2>
 * <p>当客户端调用 {@code context.pay()} 时，
 * 上下文将调用委托给当前状态对象的 {@code pay(context)} 方法。
 * 如果该操作合法，状态对象会在处理完毕后调用
 * {@link #setState(OrderState)} 切换上下文到新状态。
 * 这样就实现了状态的自动流转。</p>
 *
 * <h2>与具体状态类的关系</h2>
 * <p>上下文与具体状态类之间是双向关联：
 * 上下文持有当前状态的引用；
 * 状态对象持有上下文的引用（用于切换状态）。</p>
 *
 */
public class OrderContext {

    /** 订单编号 */
    private final String orderId;
    /** 当前订单状态，初始为已创建 */
    private OrderState state;

    /**
     * 构造一个订单上下文。
     *
     * <p>新创建的订单默认处于"已创建"状态。</p>
     *
     * @param orderId 订单编号
     */
    public OrderContext(String orderId) {
        this.orderId = orderId;
        // 修复原代码中 null state 导致 NPE 的问题：
        // 新创建的订单默认处于"已创建"状态
        this.state = new CreatedState();
    }

    /**
     * 设置当前状态。
     *
     * <p>此方法由具体状态类在合法操作完成后调用，
     * 用于切换到新的状态。</p>
     *
     * @param state 新的订单状态
     */
    public void setState(OrderState state) {
        this.state = state;
    }

    // ==================== 委托给当前状态的方法 ====================

    /**
     * 支付订单 — 委托给当前状态处理。
     *
     * @throws IllegalStateException 当当前状态不允许支付时抛出
     */
    public void pay() {
        System.out.println("[订单" + orderId + "] 尝试支付...");
        state.pay(this);
    }

    /**
     * 发货 — 委托给当前状态处理。
     *
     * @throws IllegalStateException 当当前状态不允许发货时抛出
     */
    public void ship() {
        System.out.println("[订单" + orderId + "] 尝试发货...");
        state.ship(this);
    }

    /**
     * 签收 — 委托给当前状态处理。
     *
     * @throws IllegalStateException 当当前状态不允许签收时抛出
     */
    public void deliver() {
        System.out.println("[订单" + orderId + "] 尝试签收...");
        state.deliver(this);
    }

    /**
     * 取消订单 — 委托给当前状态处理。
     *
     * @throws IllegalStateException 当当前状态不允许取消时抛出
     */
    public void cancel() {
        System.out.println("[订单" + orderId + "] 尝试取消...");
        state.cancel(this);
    }

    /** @return 当前状态的描述 */
    public String getStateDescription() {
        return state.getClass().getSimpleName();
    }
}
