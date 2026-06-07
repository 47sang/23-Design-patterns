/**
 * 桥接模式（Bridge Pattern）
 *
 * <h2>模式说明</h2>
 * <p>将<strong>抽象部分</strong>与<strong>实现部分</strong>分离，
 * 使它们都可以独立地变化。</p>
 *
 * <h2>核心问题</h2>
 * <p>当一个类同时沿<strong>两个维度</strong>变化时，
 * 如果使用继承会导致"类爆炸"问题。</p>
 * <pre>
 * 例如：饮品（抽象维度）× 规格（实现维度）
 * 如果不使用桥接模式：
 *   KissTeaLarge, KissTeaSmall, IceTeaLarge, IceTeaSmall ...
 *   → 新增一种饮品就要新增 N 个类（N=规格数量），类爆炸！
 *
 * 使用桥接模式：
 *   AbstractTea（抽象层，持有 Size 引用） + Size 接口（实现层）
 *   KissTea extends AbstractTea, IceTea extends AbstractTea
 *   Large implements Size, Small implements Size
 *   → 新增饮品只需新增一个类，新增规格也只需新增一个类
 * </pre>
 *
 * <h2>结构</h2>
 * <pre>
 *               ┌──────────────────────────┐
 *               │   AbstractTea (抽象)     │
 *               │   - Size size            │  ← 持有一个实现接口的引用
 *               │   + getType()            │
 *               └────────────┬─────────────┘
 *                            │ 继承
 *               ┌────────────┼─────────────┐
 *               │            │             │
 *          ┌────┴────┐  ┌───┴────┐  ┌───┴────┐
 *          │ KissTea │  │IceTea  │  │ ...    │  ← 具体抽象（不关心实现细节）
 *          └─────────┘  └────────┘  └────────┘
 *
 *               ┌──────────────┐
 *               │   Size       │  ← 实现接口
 *               │  + getSize() │
 *               └──────┬───────┘
 *                      │ 实现
 *               ┌──────┼───────┐
 *               │      │       │
 *          ┌────┴──┐┌──┴───┐┌──┴────┐
 *          │ Large ││Small ││Medium │  ← 具体实现
 *          └───────┘└──────┘└───────┘
 * </pre>
 *
 * <h2>桥接 vs 策略模式</h2>
 * <ul>
 *   <li><strong>桥接</strong>：两个维度独立变化，抽象持有实现的引用，通常是组合关系</li>
 *   <li><strong>策略</strong>：算法可互换，通常是运行时选择一个策略执行</li>
 *   <li>区分点：桥接的两个维度都很重要且可能同时变化；策略侧重"选一个来用"</li>
 * </ul>
 *
 * <h2>业务场景</h2>
 * <ul>
 *   <li><strong>消息推送</strong>：消息类型（通知、告警、营销）× 推送渠道（短信、邮件、App 推送、站内信），每种消息可以走不同渠道，桥接让两个维度独立扩展</li>
 *   <li><strong>跨平台 GUI</strong>：控件（按钮、文本框、列表）× 渲染引擎（Windows GDI、macOS Core Graphics、Web Canvas），同一控件在不同平台上渲染方式不同</li>
 *   <li><strong>持久化框架</strong>：领域对象（用户、订单、商品）× 存储方式（MySQL、MongoDB、Redis、Elasticsearch），业务逻辑不关心数据存在哪里</li>
 *   <li><strong>加密解密</strong>：数据流（文件、网络包、数据库字段）× 加密算法（AES、RSA、SM4），加密算法可以独立替换</li>
 * </ul>
 *
 * <h2>识别桥接模式的方法</h2>
 * <p>当你发现自己要写的类名是两个维度的笛卡尔积时（如 <code>MysqlUserDao</code>、<code>MongoUserDao</code>、<code>MysqlOrderDao</code>、<code>MongoOrderDao</code>），大概率应该用桥接模式。</p>
 *
 * @see patterns.structural.bridge 桥接示例
 */
package patterns.structural.bridge;
