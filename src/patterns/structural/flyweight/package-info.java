/**
 * 享元模式（Flyweight Pattern）
 *
 * <h2>模式说明</h2>
 * <p>运用共享技术有效地支持大量细粒度的对象。
 * 享元模式的核心是<strong>区分内部状态和外部状态</strong>，
 * 通过共享不可变的内部状态来减少对象数量。</p>
 *
 * <h2>核心概念</h2>
 * <ul>
 *   <li><strong>内部状态（Intrinsic State）</strong>：
 *       不随环境变化而变化，可以共享的信息（如棋子的颜色、字符的字体）</li>
 *   <li><strong>外部状态（Extrinsic State）</strong>：
 *       随环境变化而变化，不可共享的信息（如棋子在大盘上的位置、字符的坐标）</li>
 * </ul>
 *
 * <h2>结构</h2>
 * <pre>
 *   ┌───────────────────────────┐
 *   │     FlyweightFactory      │  ← 享元工厂（管理享元池）
 *   │  - pool: Map&lt;key, FW&gt;    │
 *   │  + getFlyweight(key)      │
 *   └────────────┬──────────────┘
 *                │ 获取/创建
 *   ┌────────────┴──────────────┐
 *   │    Flyweight (接口)       │
 *   │  + operation(extrinsic)   │  ← 接受外部状态作为方法参数
 *   └────────────┬──────────────┘
 *                │ 实现
 *   ┌────────────┴──────────────┐
 *   │   ConcreteFlyweight       │
 *   │  - intrinsicState         │  ← 内部状态（共享，不可变）
 *   └───────────────────────────┘
 * </pre>
 *
 * <h2>Java 中的享元应用</h2>
 * <ul>
 *   <li><strong>String 常量池</strong>：字符串字面量共享同一个对象</li>
 *   <li><strong>Integer.valueOf()</strong>：[-128, 127] 范围内的 Integer 对象复用</li>
 *   <li><strong>数据库连接池</strong>：连接对象复用</li>
 *   <li><strong>线程池</strong>：线程对象复用</li>
 * </ul>
 *
 * <h2>与单例的区别</h2>
 * <ul>
 *   <li><strong>单例</strong>：一个类只有一个实例</li>
 *   <li><strong>享元</strong>：一个类可以有多个实例，但通过共享来减少数量</li>
 *   <li>享元池中的对象数量取决于内部状态的不同取值数量</li>
 * </ul>
 *
 * @see patterns.structural.flyweight 享元模式示例
 */
package patterns.structural.flyweight;
