/**
 * 责任链模式（Chain of Responsibility Pattern）
 *
 * <h2>模式说明</h2>
 * <p>为请求创建一条接收者对象的链，避免请求发送者与接收者耦合在一起。
 * 多个对象都有可能接收请求，将它们连接成一条链，
 * 沿着链传递请求，直到有对象处理它为止。</p>
 *
 * <h2>现实类比</h2>
 * <p>公司报销流程：</p>
 * <pre>
 * 金额 ≤ 500元  → 直属主管审批
 * 500 < 金额 ≤ 5000元 → 部门经理审批
 * 5000 < 金额 ≤ 50000元 → 总经理审批
 * 金额 > 50000元 → 董事长审批（或拒绝）
 *
 * 报销单沿着审批链传递，每一步判断自己是否能处理。
 * 能处理就处理，不能处理就传递给下一个审批人。
 * </pre>
 *
 * <h2>结构</h2>
 * <pre>
 *   ┌──────────────┐     ┌──────────────┐     ┌──────────────┐
 *   │  Handler A   │────►│  Handler B   │────►│  Handler C   │
 *   │ (审批主管)   │     │ (审批经理)   │     │ (审批总监)   │
 *   └──────┬───────┘     └──────┬───────┘     └──────┬───────┘
 *          │                     │                     │
 *     ┌────┴────┐           ┌────┴────┐           ┌────┴────┐
 *     │能处理？  │           │能处理？  │           │能处理？  │
 *     │→处理    │           │→处理    │           │→处理    │
 *     │→传给B   │           │→传给C   │           │→结束    │
 *     └─────────┘           └─────────┘           └─────────┘
 * </pre>
 *
 * <h2>两种链的构建方式</h2>
 * <ul>
 *   <li><strong>经典链表</strong>：每个 Handler 持有下一个 Handler 的引用，
 *       客户端手动连接（如 handler1.connect(handler2).connect(handler3)）</li>
 *   <li><strong>职责链框架</strong>：使用 List 存储所有 Handler，
 *       框架自动按顺序或策略选择下一个 Handler</li>
 * </ul>
 *
 * <h2>业务场景</h2>
 * <ul>
 *   <li>Servlet Filter：多个 Filter 依次处理 HTTP 请求</li>
 *   <li>Spring Interceptor：拦截器链</li>
 *   <li>日志级别过滤：DEBUG → INFO → WARN → ERROR</li>
 * </ul>
 *
 * @see patterns.behavioral.chain_of_responsibility 责任链示例
 */
package patterns.behavioral.chain_of_responsibility;
