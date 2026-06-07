/**
 * 策略模式（Strategy Pattern）
 *
 * <h2>模式说明</h2>
 * <p>定义一系列算法，把它们一个个封装起来，
 * 并且使它们可相互替换。策略模式让算法的变化独立于使用算法的客户。</p>
 *
 * <h2>现实类比</h2>
 * <p>出行方式选择：</p>
 * <pre>
 * 从家到公司，有多种出行策略：
 *   - 地铁：不堵车，便宜，但可能拥挤
 *   - 打车：舒适，贵，可能堵车
 *   - 骑行：自由，看天气
 *   - 自驾：方便，停车麻烦
 *
 * 你（客户端）根据当天情况选择一个策略，
 * 切换策略不需要改变你的身份（你始终是同一个出行者）
 * </pre>
 *
 * <h2>结构</h2>
 * <pre>
 *   ┌────────────────┐       ┌────────────────┐
 *   │   Context      │       │   Strategy     │  ← 抽象策略
 *   │  (上下文)      │──────►│  + algorithm() │
 *   │  - Strategy    │       └────────┬───────┘
 *   │  + execute()   │                │ 实现
 *   └────────────────┘       ┌────────┼─────────┐
 *                                  │        │
 *                            ┌────┴──┐ ┌───┴────┐
 *                            │StrA   │ │StrB    │  ← 具体策略
 *                            └───────┘ └────────┘
 * </pre>
 *
 * <h2>策略模式的三要素</h2>
 * <ol>
 *   <li><strong>策略接口（Strategy）</strong>：声明所有支持的算法的公共接口</li>
 *   <li><strong>具体策略（ConcreteStrategy）</strong>：实现策略接口的具体算法</li>
 *   <li><strong>上下文（Context）</strong>：持有一个策略引用，将客户请求委托给策略对象</li>
 * </ol>
 *
 * <h2>策略选择方式</h2>
 * <ul>
 *   <li><strong>条件判断</strong>：根据参数/条件在代码中选择策略（最简单）</li>
 *   <li><strong>配置注入</strong>：通过配置文件或注解指定策略（Spring 的 Strategy 模式）</li>
 *   <li><strong>函数式接口</strong>：Java 8+ 用 Lambda 直接传递策略，无需创建具体类</li>
 * </ul>
 *
 * <h2>Java 中的实际应用</h2>
 * <ul>
 *   <li>{@code java.util.Comparator} —— 比较策略，可以自定义排序规则</li>
 *   <li>{@code java.util.concurrent.ThreadPoolExecutor} 的拒绝策略（{@code RejectedExecutionHandler}）</li>
 *   <li>Spring 的 {@code @Qualifier} 在运行时选择不同的 Bean 实现</li>
 * </ul>
 *
 * @see patterns.behavioral.strategy 策略模式示例
 */
package patterns.behavioral.strategy;
