/**
 * 代理模式（Proxy Pattern）
 *
 * <h2>模式说明</h2>
 * <p>为其他对象提供一种代理以控制对这个对象的访问。</p>
 *
 * <h2>为什么需要代理？</h2>
 * <p>在某些场景下，直接访问对象会有问题：</p>
 * <ul>
 *   <li><strong>权限控制</strong>：不是所有人都有权限调用某个方法</li>
 *   <li><strong>延迟加载</strong>：对象创建成本高，真正需要时才初始化</li>
 *   <li><strong>远程调用</strong>：对象在远程服务器上，需要本地代理转发</li>
 *   <li><strong>日志/事务</strong>：在调用前后需要统一做一些事情（AOP 本质就是代理）</li>
 * </ul>
 *
 * <h2>代理类型</h2>
 * <table>
 *   <tr>
 *     <th>类型</th>
 *     <th>说明</th>
 *     <th>实现方式</th>
 *   </tr>
 *   <tr>
 *     <td>静态代理</td>
 *     <td>代理类在编译期确定，由程序员编写或工具生成</td>
 *     <td>继承或实现相同接口</td>
 *   </tr>
 *   <tr>
 *     <td>JDK 动态代理</td>
 *     <td>运行时通过反射动态生成代理类，适用于接口</td>
 *     <td>{@code java.lang.reflect.Proxy}</td>
 *   </tr>
 *   <tr>
 *     <td>CGLIB 代理</td>
 *     <td>运行时通过字节码技术生成子类，适用于没有接口的类</td>
 *     <td>ASM / CGLIB 库</td>
 *   </tr>
 * </table>
 *
 * <h2>结构（静态代理）</h2>
 * <pre>
 *   ┌─────────────┐       ┌─────────────┐       ┌─────────────┐
 *   │   Subject   │◄──────│   Proxy     │──────►│ SubjectImpl │
 *   │  (抽象主题) │       │  (代理类)   │       │ (真实主题)   │
 *   └─────────────┘       └─────────────┘       └─────────────┘
 *        ▲                        │
 *   ┌────┴────┐            ┌──────┴──────┐
 *   │ Client  │            │  前置处理   │
 *   │ (客户端) │            │  target.方法 │
 *   └────────┘            │  后置处理   │
 *                         └─────────────┘
 * </pre>
 *
 * <h2>与装饰模式的对比</h2>
 * <ul>
 *   <li><strong>装饰器</strong>：目的是<strong>增强</strong>功能，客户端知道自己拿到的是装饰后的对象</li>
 *   <li><strong>代理</strong>：目的是<strong>控制</strong>访问，客户端通常不知道代理的存在</li>
 *   <li>两者结构几乎一样（都是组合+委托），但意图不同</li>
 * </ul>
 *
 * @see patterns.structural.proxy 代理模式示例（静态代理 + JDK 动态代理）
 */
package patterns.structural.proxy;
