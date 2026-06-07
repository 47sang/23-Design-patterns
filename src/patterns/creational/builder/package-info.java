/**
 * 建造者模式（Builder Pattern）
 *
 * <h2>模式说明</h2>
 * <p>建造者模式将<strong>复杂对象的构建</strong>与其<strong>表示</strong>分离，
 * 使得同样的构建过程可以创建不同的表示。</p>
 *
 * <p>当一个类的构造函数包含<strong>大量可选参数</strong>时，会导致：
 * <ul>
 *   <li>构造函数参数列表过长（ telescoping constructor 问题）</li>
 *   <li>客户端代码难以理解哪个参数是做什么的</li>
 *   <li>容易传错参数顺序导致编译通过但语义错误</li>
 * </ul>
 * 建造者模式通过链式调用优雅地解决了这些问题。</p>
 *
 * <h2>结构</h2>
 * <pre>
 *  ┌──────────────────────────────────────────────┐
 *  │  Student                                     │
 *  │  - private constructor (只能通过 Builder 创建) │
 *  │  + builder() → StudentBuilder               │
 *  └──────────────────────────────────────────────┘
 *                       │ 返回
 *  ┌──────────────────────────────────────────────┐
 *  │  StudentBuilder (静态内部类)                  │
 *  │  + name(String) → StudentBuilder (链式调用)  │
 *  │  + age(int) → StudentBuilder                 │
 *  │  + build() → Student                         │
 *  └──────────────────────────────────────────────┘
 * </pre>
 *
 * <h2>核心思想</h2>
 * <ol>
 *   <li>目标类的构造函数设为 <strong>private</strong>，强制客户端通过 Builder 创建</li>
 *   <li>Builder 提供链式 API，每个方法返回 this，支持流畅调用</li>
 *   <li>Builder 最终调用目标类的 private 构造函数完成对象创建</li>
 *   <li>在 build() 方法中进行参数校验，保证构建出的对象始终处于有效状态</li>
 * </ol>
 *
 * <h2>Java 中的实际应用</h2>
 * <ul>
 *   <li>{@code StringBuilder} —— 字符串的建造者</li>
 *   <li>{@code java.nio.IntBuffer} / {@code ByteBuffer} —— NIO 中的建造者模式</li>
 *   <li>Lombok 的 {@code @Builder} 注解 —— 自动生成建造者代码</li>
 * </ul>
 *
 * <h2>业务场景</h2>
 * <ul>
 *   <li><strong>电商订单</strong>：订单包含必填字段（用户 ID、商品 ID）和大量可选字段（地址、备注、优惠券、发票信息），Builder 让每个参数的含义一目了然</li>
 *   <li><strong>HTTP 请求构建</strong>：请求包含 URL、方法、 headers、body、超时等多个可选参数，Builder 链式调用比 telescoping constructor 清晰得多</li>
 *   <li><strong>SQL 查询构建</strong>：动态拼接 WHERE 条件、ORDER BY、LIMIT 等可选子句，Builder 可以只在需要时添加条件</li>
 *   <li><strong>配置文件</strong>：系统配置对象有数十个可选参数（超时、重试次数、线程池大小、日志级别等），Builder 让配置代码自文档化</li>
 * </ul>
 *
 * <h2>注意事项</h2>
 * <ul>
 *   <li>如果对象只有 2-3 个参数，直接使用构造函数即可，不需要 Builder</li>
 *   <li>Builder 本身有一定样板代码开销，Lombok {@code @Builder} 可以自动生成</li>
 *   <li>可变对象用 Builder 构建后仍然可以被修改——如果要求不可变，确保所有字段都是 {@code final}</li>
 * </ul>
 *
 */
package patterns.creational.builder;
