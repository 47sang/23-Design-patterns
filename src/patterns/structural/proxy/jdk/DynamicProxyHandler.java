package patterns.structural.proxy.jdk;

import patterns.structural.proxy.OrderService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理处理器（InvocationHandler）
 *
 * <p>实现 {@link InvocationHandler} 接口，
 * 在运行时动态创建代理对象，统一处理方法调用。</p>
 *
 * <h2>JDK 动态代理 vs CGLIB 代理</h2>
 * <table>
 *   <tr>
 *     <th>对比维度</th>
 *     <th>JDK 动态代理</th>
 *     <th>CGLIB 代理</th>
 *   </tr>
 *   <tr>
 *     <td>代理对象</td>
 *     <td>基于接口，运行时生成接口的实现类</td>
 *     <td>基于类，运行时生成目标类的子类</td>
 *   </tr>
 *   <tr>
 *     <td>使用条件</td>
 *     <td>目标对象必须实现接口</td>
 *     <td>目标对象可以是普通类（无接口也可）</td>
 *   </tr>
 *   <tr>
 *     <td>final 方法</td>
 *     <td>无法代理 final 方法（接口中无 final）</td>
 *     <td>无法代理 final 方法（子类无法覆盖）</td>
 *   </tr>
 *   <tr>
 *     <td>final 类</td>
 *     <td>无限制（代理的是接口）</td>
 *     <td>无法代理 final 类（无法生成子类）</td>
 *   </tr>
 *   <tr>
 *     <td>性能</td>
 *     <td>JDK 8+ 使用 MethodHandle 优化，性能接近 CGLIB</td>
 *     <td>使用 ASM 字节码操作，首次创建较慢，运行速度快</td>
 *   </tr>
 *   <tr>
 *     <td>Spring 默认</td>
 *     <td>有接口时默认使用 JDK 动态代理</td>
 *     <td>无接口时自动降级使用 CGLIB</td>
 *   </tr>
 * </table>
 *
 * <h2>JDK 动态代理的核心机制</h2>
 * <ol>
 *   <li>通过 {@code Proxy.newProxyInstance()} 动态生成代理类</li>
 *   <li>代理类实现了目标接口，所有方法调用都转发到 InvocationHandler</li>
 *   <li>在 {@code invoke()} 方法中，可以在调用真实方法前后插入横切逻辑</li>
 * </ol>
 *
 * <h2>优势</h2>
 * <ul>
 *   <li>不需要为每个接口编写代理类，一个 Handler 可以代理任意接口</li>
 *   <li>在运行时动态决定代理行为，更加灵活</li>
 *   <li>Spring AOP 默认使用 JDK 动态代理（有接口时）</li>
 * </ul>
 *
 * @see java.lang.reflect.InvocationHandler
 * @see java.lang.reflect.Proxy
 */
public class DynamicProxyHandler implements InvocationHandler {

    /**
     * 持有所代理的真实对象。
     *
     * <p>在动态代理中，真实对象在运行时传入，
     * 同一个 Handler 可以代理不同的真实对象。</p>
     */
    private final Object realSubject;

    /**
     * 构造器：传入需要代理的真实对象。
     *
     * @param realSubject 被代理的真实对象（必须实现某个接口）
     */
    DynamicProxyHandler(Object realSubject) {
        this.realSubject = realSubject;
    }

    /**
     * 代理对象的所有方法调用都会经过此方法。
     *
     * <p>这是动态代理的核心：在方法调用前后插入横切逻辑（如权限检查、日志等）。</p>
     *
     * <h2>执行流程</h2>
     * <ol>
     *   <li>收到方法调用（proxy, method, args）</li>
     *   <li>前置处理（如权限检查）</li>
     *   <li>调用真实对象的方法（method.invoke）</li>
     *   <li>后置处理（如日志记录）</li>
     *   <li>返回方法执行结果</li>
     * </ol>
     *
     * @param proxy  代理对象（一般不需要直接使用）
     * @param method 被调用的方法（Method 对象）
     * @param args   方法参数
     * @return 方法执行结果
     * @throws Throwable 方法执行可能抛出的异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();

        // ========== 前置处理：权限检查 ==========
        if ("cancelOrder".equals(methodName)) {
            // cancelOrder 方法的第一个参数是 userId
            String userId = (args != null && args.length > 0) ? (String) args[0] : null;
            System.out.println("[动态代理] 前置检查：取消订单需要管理员权限");
            if (userId == null || !userId.startsWith("admin")) {
                System.out.printf("[动态代理] 权限不足！用户 %s 不是管理员，拒绝执行 %s%n", userId, methodName);
                return null;
            }
            System.out.println("[动态代理] 权限验证通过，执行 " + methodName);
        } else {
            System.out.println("[动态代理] 前置检查：" + methodName + " 操作对所有用户开放，直接放行");
        }

        // ========== 委托调用真实对象的方法 ==========
        Object result = method.invoke(realSubject, args);

        // ========== 后置处理：日志记录 ==========
        System.out.println("[动态代理] 后置处理：" + methodName + " 执行完成，记录操作日志");

        return result;
    }

    /**
     * 创建动态代理对象的工厂方法。
     *
     * <p>使用 {@link Proxy#newProxyInstance()} 动态生成实现指定接口的代理类。</p>
     *
     * <h2>newProxyInstance 参数说明</h2>
     * <ul>
     *   <li><strong>ClassLoader</strong>：代理类的类加载器（通常使用目标接口的类加载器）</li>
     *   <li><strong>Class[] interfaces</strong>：代理类要实现的接口列表</li>
     *   <li><strong>InvocationHandler</strong>：处理方法调用的回调对象</li>
     * </ul>
     *
     * @param <T>         代理接口类型
     * @param realSubject 被代理的真实对象
     * @param interfaces  代理类要实现的接口
     * @return 动态生成的代理对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Object realSubject, Class<?>... interfaces) {
        return (T) Proxy.newProxyInstance(
            interfaces[0].getClassLoader(),
            interfaces,
            new DynamicProxyHandler(realSubject)
        );
    }
}
