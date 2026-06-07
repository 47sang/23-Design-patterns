package patterns.structural.proxy;

/**
 * 订单服务代理（代理 / Proxy）—— 静态代理实现
 *
 * <p>为 {@link OrderService} 提供权限控制代理，
 * 在调用真实服务前检查用户角色。</p>
 *
 * <h2>代理的核心职责</h2>
 * <ol>
 *   <li><strong>前置检查</strong>：在执行真实方法前进行权限验证</li>
 *   <li><strong>委托调用</strong>：检查通过后，调用真实主题的方法</li>
 *   <li><strong>后置处理</strong>（可选）：在调用后记录日志等</li>
 * </ol>
 *
 * <h2>设计约束</h2>
 * <p>本实现采用<strong>接口 + 组合</strong>方式，而非抽象类继承，
 * 符合"组合优于继承"的设计原则。
 * 代理类实现 OrderService 接口，持有 OrderServiceImpl 的引用，
 * 在方法中先做权限检查，再委托给真实服务。</p>
 *
 * <h2>权限规则</h2>
 * <ul>
 *   <li>placeOrder（下单）：所有用户可执行</li>
 *   <li>cancelOrder（取消订单）：仅管理员（userRole="admin"）可执行</li>
 * </ul>
 *
 * @see OrderService 订单服务接口
 * @see OrderServiceImpl 真实主题
 */
public class OrderServiceProxy implements OrderService {

    /**
     * 持有所代理的真实服务对象的引用（组合关系）。
     *
     * <p>通过组合而非继承来持有真实主题，
     * 符合"组合优于继承"原则，更加灵活。</p>
     */
    private final OrderService realService;

    /**
     * 构造器：传入需要代理的真实服务实例。
     *
     * @param realService 被代理的真实订单服务
     */
    OrderServiceProxy(OrderService realService) {
        this.realService = realService;
    }

    /**
     * 检查用户是否为管理员。
     *
     * <p>在本示例中，通过判断 userId 是否以 "admin" 开头来模拟角色判断。
     * 实际项目中通常会从 Session 或 Token 中获取用户角色。</p>
     *
     * @param userId 用户 ID
     * @return 如果是管理员返回 true，否则返回 false
     */
    private boolean isAdmin(String userId) {
        // 模拟：userId 以 "admin" 开头的用户为管理员
        return userId != null && userId.startsWith("admin");
    }

    @Override
    public void placeOrder(String userId, String itemName, int quantity) {
        System.out.println("[代理] 前置检查：下单操作对所有用户开放，直接放行");
        // 委托给真实服务执行下单
        realService.placeOrder(userId, itemName, quantity);
        System.out.println("[代理] 后置处理：下单操作完成，记录操作日志");
    }

    @Override
    public void cancelOrder(String userId, String orderId) {
        System.out.println("[代理] 前置检查：取消订单需要管理员权限");
        if (!isAdmin(userId)) {
            System.out.printf("[代理] 权限不足！用户 %s 不是管理员，拒绝取消订单 %s%n", userId, orderId);
            return;
        }
        System.out.println("[代理] 权限验证通过，执行取消操作");
        // 委托给真实服务执行取消
        realService.cancelOrder(userId, orderId);
        System.out.println("[代理] 后置处理：取消操作完成，记录操作日志");
    }
}
