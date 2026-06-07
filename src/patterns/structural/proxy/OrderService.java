package patterns.structural.proxy;

/**
 * 订单服务接口（抽象主题 / Subject）
 *
 * <p>代理模式中的抽象主题，定义了订单服务的核心操作。
 * 客户端面向此接口编程，不需要知道实际使用的是真实服务还是代理。</p>
 *
 * <h2>代理模式中的角色</h2>
 * <ul>
 *   <li><strong>Subject（抽象主题）</strong>：OrderService（本接口）</li>
 *   <li><strong>RealSubject（真实主题）</strong>：OrderServiceImpl</li>
 *   <li><strong>Proxy（代理）</strong>：OrderServiceProxy</li>
 * </ul>
 *
 * <h2>静态代理 vs JDK 动态代理</h2>
 * <ul>
 *   <li><strong>静态代理</strong>：代理类在编译期确定，程序员手动编写</li>
 *   <li><strong>JDK 动态代理</strong>：运行时通过反射动态生成代理类，更灵活</li>
 * </ul>
 *
 * @see OrderServiceImpl 真实主题
 * @see OrderServiceProxy 静态代理
 */
public interface OrderService {

    /**
     * 下单操作。
     *
     * <p>所有用户都可以执行下单操作。</p>
     *
     * @param userId   用户 ID
     * @param itemName 商品名称
     * @param quantity 购买数量
     */
    void placeOrder(String userId, String itemName, int quantity);

    /**
     * 取消订单操作。
     *
     * <p>只有管理员角色可以执行取消订单操作。
     * 代理类会在此方法上添加权限检查。</p>
     *
     * @param userId 用户 ID
     * @param orderId 订单 ID
     */
    void cancelOrder(String userId, String orderId);
}
