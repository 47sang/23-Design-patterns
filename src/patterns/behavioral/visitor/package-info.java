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
 * <h2>业务场景</h2>
 * <ul>
 *   <li><strong>编译器</strong>：AST（抽象语法树）上的各种分析——类型检查、代码生成、优化、格式化，每种分析都是一个 Visitor，新增分析不需要改动 AST 节点类</li>
 *   <li><strong>财务报表</strong>：同一组财务数据（收入、支出、资产、负债）需要输出不同报表（利润表、资产负债表、现金流量表），每个报表是一个 Visitor</li>
 *   <li><strong>文档导出</strong>：文档元素（标题、段落、表格、图片）需要导出为不同格式（PDF、HTML、Markdown），每个导出器是一个 Visitor</li>
 *   <li><strong>电商商品</strong>：商品元素（实物商品、虚拟商品、套餐）需要不同的计算逻辑（价格计算、税费计算、库存扣减），每个计算逻辑是一个 Visitor</li>
 * </ul>
 *
 * <h2>现代 Java 改进</h2>
 * <p>Java 16+ 引入的 <strong>密封类（sealed interface）</strong>可以让 Visitor 更加安全：</p>
 * <pre>
 * // 编译器确保所有 Element 子类型都被穷尽
 * public sealed interface Element permits ConcreteA, ConcreteB, ConcreteC {}
 *
 * // Visitor 的 switch 表达式编译器会检查是否覆盖了所有子类型
 * public String accept(Visitor v) {
 *     return switch (this) {
 *         case ConcreteA a -> v.visit(a);
 *         case ConcreteB b -> v.visit(b);
 *         case ConcreteC c -> v.visit(c);
 *     };
 * }
 * </pre>
 *
 * <h2>注意事项</h2>
 * <ul>
 *   <li>Visitor 模式适合<strong>对象结构稳定、操作频繁变化</strong>的场景。如果元素类型经常变（每迭代就加新元素），Visitor 的代价就太大了——每次加元素都要修改所有 Visitor</li>
 *   <li>对于只有 2-3 种元素类型的简单场景，用策略模式或简单的 if-else 更实际</li>
 *   <li>Visitor 和迭代器经常配合使用：Visitor 遍历元素结构，迭代器提供遍历机制</li>
 * </ul>
 *
 * @see patterns.behavioral.visitor 访问者模式示例
 */
package patterns.behavioral.visitor;
