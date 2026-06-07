/**
 * 状态模式（State Pattern）
 *
 * <h2>模式说明</h2>
 * <p>允许一个对象在其内部状态改变时改变它的行为，
 * 对象看起来似乎修改了它的类。</p>
 *
 * <h2>为什么不直接用 if-else？</h2>
 * <pre>
 * 不用状态模式（糟糕的写法）：
 *   void handle() {
 *       if (state == ORDER_CREATED) { ... }
 *       else if (state == ORDER_PAID) { ... }
 *       else if (state == ORDER_SHIPPED) { ... }
 *       else if (state == ORDER_DELIVERED) { ... }
 *       // 新增状态就要修改这个方法，违反开闭原则
 *   }
 *
 * 使用状态模式：
 *   interface OrderState { void handle(Order order); }
 *   class CreatedState implements OrderState { ... }
 *   class PaidState implements OrderState { ... }
 *   // 新增状态只需新增一个类，不修改已有代码
 * </pre>
 *
 * <h2>结构</h2>
 * <pre>
 *   ┌─────────────────────┐       ┌──────────────────┐
 *   │      Context        │       │    State         │  ← 抽象状态
 *   │  （上下文对象）      │──────►│  + handle()      │
 *   │  - State state      │       └────────┬─────────┘
 *   │  + setState()       │                │ 实现
 *   │  + request()        │       ┌────────┼─────────┐
 *   └─────────────────────┘       │        │         │
 *                                  │   ┌────┴───┐ ┌──┴────┐
 *                                  │   │StateA  │ │StateB │
 *                                  │   └────────┘ └───────┘
 *                                  │  每个状态类封装该状态下的所有行为
 *                                  │  状态转换逻辑在各状态类内部完成
 * </pre>
 *
 * <h2>状态模式 vs 策略模式</h2>
 * <table>
 *   <tr>
 *     <th></th>
 *     <th>状态模式</th>
 *     <th>策略模式</th>
 *   </tr>
 *   <tr>
 *     <td><strong>关注点</strong></td>
 *     <td>对象的<strong>状态转换</strong>和不同状态下的行为</td>
 *     <td>算法的<strong>可替换性</strong></td>
 *   </tr>
 *   <tr>
 *     <td><strong>状态间关系</strong></td>
 *     <td>状态之间通常知道彼此，存在转换关系</td>
 *     <td>策略之间相互独立，不知道对方的存在</td>
 *   </tr>
 *   <tr>
 *     <td><strong>选择方式</strong></td>
 *     <td>由 Context 根据当前状态自动选择</td>
 *     <td>由客户端显式选择使用哪个策略</td>
 *   </tr>
 * </table>
 *
 * <h2>业务场景</h2>
 * <ul>
 *   <li>订单状态：待支付 → 已支付 → 已发货 → 已签收，每个状态行为不同</li>
 *   <li>电梯控制：开门 → 关门 → 运行 → 停止</li>
 *   <li>TCP 连接：CLOSED → LISTEN → SYN_SENT → ESTABLISHED → CLOSED</li>
 * </ul>
 *
 * @see patterns.behavioral.state 状态模式示例
 */
package patterns.behavioral.state;
