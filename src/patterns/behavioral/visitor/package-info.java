/**
 * 访问者模式（Visitor Pattern）
 *
 * <h2>模式说明</h2>
 * <p>表示一个作用于某对象结构中的各元素的操作，
 * 它使你可以在<strong>不改变各元素的类</strong>的前提下定义作用于这些元素的新操作。</p>
 *
 * <h2>核心思想：双分派（Double Dispatch）</h2>
 * <p>访问者模式的核心机制是<strong>双分派</strong>：</p>
 * <pre>
 * 第一次分派：Client 调用 element.accept(visitor)
 *             → 确定是哪个 Element 子类（依赖 Element 的实际类型）
 *
 * 第二次分派：Element 内部调用 visitor.visit(this)
 *             → 确定调用 Visitor 的哪个重载方法（依赖 Visitor 的实际类型）
 *
 * 两次分派共同决定了最终执行哪个方法。
 * </pre>
 *
 * <h2>结构</h2>
 * <pre>
 *   ┌──────────────────────────────────────────┐
 *   │  ObjectStructure                         │
 *   │  (对象结构，存储 Element 集合)            │
 *   │  + accept(Visitor)                       │
 *   └─────────────┬────────────────────────────┘
 *                 │ 包含
 *   ┌─────────────┼─────────────┐
 *   │             │             │
 *  ┌┴─────┐   ┌──┴───┐   ┌───┴───┐
 *  │Element│   │Element│  │Element │  ← 元素接口
 *  └───┬───┘   └───┬───┘  └───┬───┘
 *      │ accept()    │          │
 *      │ visitor      │          │
 *      │.visit(this)  │          │
 *      ▼             ▼          ▼
 *  ┌───┴─────┐ ┌───┴───┐ ┌───┴───┐
 *  │ConcreteA│ │ConcrB │ │ConcrC │  ← 具体元素
 *  └─────────┘ └───────┘ └───────┘
 *
 *   ┌──────────────────────────────────────────┐
 *   │  Visitor (接口)                           │
 *   │  + visit(ConcreteA a)                     │
 *   │  + visit(ConcreteB b)                     │
 *   │  + visit(ConcreteC c)                     │
 *   └─────────────┬────────────────────────────┘
 *                 │ 实现
 *   ┌─────────────┴────────────────────────────┐
 *   │  ConcreteVisitor                         │
 *   │  (不同的访问者实现不同的操作)              │
 *   └──────────────────────────────────────────┘
 * </pre>
 *
 * <h2>优劣势</h2>
 * <ul>
 *   <li><strong>优点</strong>：可以在不修改元素类的情况下添加新操作（如报表、导出、统计分析）</li>
 *   <li><strong>缺点</strong>：新增元素类型需要修改所有 Visitor 的接口和实现；
 *       元素类和 Visitor 之间是强耦合的；理解成本较高</li>
 * </ul>
 *
 * <h2>何时使用</h2>
 * <ul>
 *   <li>对象结构稳定，但需要频繁在其上定义新操作（如编译器 AST 的各种分析）</li>
 *   <li>需要对一个对象结构中的对象进行很多不相关的操作，
 *       又不想这些操作"污染"对象本身的类</li>
 * </ul>
 *
 * @see patterns.behavioral.visitor 访问者模式示例
 */
package patterns.behavioral.visitor;
