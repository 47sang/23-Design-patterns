package patterns.structural.proxy;

/**
 * 静态代理模式演示入口
 *
 * <p>演示订单服务的权限控制代理，
 * 展示普通用户和管理员在取消订单时的不同行为。</p>
 *
 * <h2>演示场景</h2>
 * <ol>
 *   <li>普通用户下单（允许）</li>
 *   <li>普通用户取消订单（拒绝）</li>
 *   <li>管理员下单（允许）</li>
 *   <li>管理员取消订单（允许）</li>
 * </ol>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 静态代理模式演示：订单服务权限控制 ==========");
        System.out.println();

        // 创建真实服务
        OrderServiceImpl realService = new OrderServiceImpl();

        // 用代理包装真实服务
        OrderServiceProxy proxy = new OrderServiceProxy(realService);

        // ========== 场景 1：普通用户下单 ==========
        System.out.println("--- 场景 1：普通用户下单 ---");
        proxy.placeOrder("user001", "宫保鸡丁", 2);
        System.out.println();

        // ========== 场景 2：普通用户取消订单（应被拒绝） ==========
        System.out.println("--- 场景 2：普通用户取消订单（应被拒绝） ---");
        proxy.cancelOrder("user001", "ORDER-20240601");
        System.out.println();

        // ========== 场景 3：管理员下单 ==========
        System.out.println("--- 场景 3：管理员下单 ---");
        proxy.placeOrder("admin001", "麻婆豆腐", 1);
        System.out.println();

        // ========== 场景 4：管理员取消订单（应被允许） ==========
        System.out.println("--- 场景 4：管理员取消订单（应被允许） ---");
        proxy.cancelOrder("admin001", "ORDER-20240602");
        System.out.println();

        System.out.println("========== 静态代理总结 ==========");
        System.out.println("静态代理通过代理类在调用前后插入权限检查逻辑");
        System.out.println("优点：控制权集中，真实服务无需关心权限逻辑");
        System.out.println("缺点：每个方法都需要在代理中写一遍委托代码，比较繁琐");
    }
}
