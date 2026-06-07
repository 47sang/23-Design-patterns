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
 */
package patterns.creational.builder;
