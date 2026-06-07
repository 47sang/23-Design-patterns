package patterns.structural.proxy;

/**
 * 订单服务实现（真实主题 / Real Subject）
 *
 * <p>代理模式中的真实主题，实现了 {@link OrderService} 接口，
 * 包含实际的业务逻辑。</p>
 *
 * <h2>设计意图</h2>
 * <p>真实主题只关注业务逻辑本身，不关心权限、日志等横切关注点。
 * 这些横切关注点由代理类来处理。</p>
 *
 * <h2>与代理的关系</h2>
 * <ul>
 *   <li>代理持有真实主题的引用</li>
 *   <li>代理在执行真实主题方法前/后添加额外逻辑</li>
 *   <li>真实主题不知道代理的存在</li>
 * </ul>
 *
 * @see OrderService 订单服务接口
 * @see OrderServiceProxy 静态代理
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public void placeOrder(String userId, String itemName, int quantity) {
        System.out.printf("[订单服务] 用户 %s 下单：%s x%d%n", userId, itemName, quantity);
        System.out.println("[订单服务] 订单创建成功！");
    }

    @Override
    public void cancelOrder(String userId, String orderId) {
        System.out.printf("[订单服务] 用户 %s 取消订单：%s%n", userId, orderId);
        System.out.println("[订单服务] 订单取消成功！");
    }
}
