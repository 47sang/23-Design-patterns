package patterns.structural.proxy.jdk;

import patterns.structural.proxy.OrderServiceImpl;
import patterns.structural.proxy.OrderService;

/**
 * JDK 动态代理模式演示入口
 *
 * <p>演示如何使用 JDK 动态代理在运行时动态创建代理对象，
 * 实现与静态代理相同的权限控制效果，但代码更简洁、更灵活。</p>
 *
 * <h2>与静态代理的对比</h2>
 * <ul>
 *   <li><strong>静态代理</strong>：需要手动编写 OrderServiceProxy 类，每个方法都要写委托代码</li>
 *   <li><strong>JDK 动态代理</strong>：一个 DynamicProxyHandler 可以代理任意接口的所有方法</li>
 *   <li><strong>灵活性</strong>：动态代理在运行时决定行为，可以通过配置文件切换代理逻辑</li>
 * </ul>
 *
 * <h2>动态代理的核心优势</h2>
 * <p>同一个 InvocationHandler 可以代理不同的接口和方法，
 * 在 invoke() 中根据 method.getName() 动态判断要执行的逻辑。
 * 这正是 Spring AOP 的实现原理。</p>
 *
 * @see DynamicProxyHandler 动态代理处理器
 * @see patterns.structural.proxy.OrderService 订单服务接口
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== JDK 动态代理模式演示 ==========");
        System.out.println();

        // 创建真实服务
        OrderServiceImpl realService = new OrderServiceImpl();

        // ========== 通过动态代理创建代理对象 ==========
        // 只需要一行代码，不需要编写 OrderServiceProxy 类
        OrderService dynamicProxy = DynamicProxyHandler.createProxy(
            realService,
            OrderService.class
        );

        // ========== 通过代理对象调用方法 ==========
        // 注意：调用的是 OrderService 接口的方法，
        // 实际执行的是 DynamicProxyHandler.invoke() 中的逻辑

        System.out.println("--- 场景 1：普通用户下单 ---");
        dynamicProxy.placeOrder("user002", "宫保鸡丁", 2);
        System.out.println();

        System.out.println("--- 场景 2：普通用户取消订单（应被拒绝） ---");
        dynamicProxy.cancelOrder("user002", "ORDER-20240603");
        System.out.println();

        System.out.println("--- 场景 3：管理员取消订单（应被允许） ---");
        dynamicProxy.cancelOrder("admin002", "ORDER-20240604");
        System.out.println();

        System.out.println("--- 场景 4：管理员下单 ---");
        dynamicProxy.placeOrder("admin002", "麻婆豆腐", 1);
        System.out.println();

        System.out.println("========== 动态代理优势总结 ==========");
        System.out.println("1. 一个 Handler 可以代理任意接口，不需要为每个接口写代理类");
        System.out.println("2. 在运行时动态决定代理行为，更灵活");
        System.out.println("3. Spring AOP、MyBatis Mapper 等都是基于 JDK 动态代理实现的");
        System.out.println("4. 限制：目标对象必须实现接口（否则使用 CGLIB）");
    }
}
