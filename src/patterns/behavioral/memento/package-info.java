/**
 * 备忘录模式（Memento Pattern）
 *
 * <h2>模式说明</h2>
 * <p>在不破坏封装性的前提下，捕获一个对象的内部状态，
 * 并在该对象之外保存这个状态。
 * 这样以后可以将对象恢复到原先保存的状态。</p>
 *
 * <h2>现实类比</h2>
 * <p>就像游戏中的"存档"功能：</p>
 * <pre>
 * 打 Boss 之前存档（保存状态）
 *   ↓
 * 打 Boss 失败 → 读取存档（恢复状态）→ 再打一次
 * 打 Boss 成功 → 继续游戏，不读档
 * </pre>
 *
 * <h2>核心角色</h2>
 * <ul>
 *   <li><strong>发起人（Originator）</strong>：需要被保存/恢复状态的对象（如学生、文档编辑器）</li>
 *   <li><strong>备忘录（Memento）</strong>：存储发起人内部状态的对象，对外不暴露具体内容</li>
 *   <li><strong>负责人（Caretaker）</strong>：负责保存和恢复备忘录，但不关心备忘录内部内容</li>
 * </ul>
 *
 * <h2>结构</h2>
 * <pre>
 *   ┌────────────────┐    ┌────────────────┐    ┌────────────────┐
 *   │   Originator   │    │    Memento     │    │   Caretaker    │
 *   │   (发起人)     │    │   (备忘录)     │    │   (负责人)     │
 *   │                │    │                │    │                │
 *   │ + save()       │───►│ + getState()   │◄───│ + save()       │
 *   │   → Memento    │    │   （内部状态）  │    │   → 存储       │
 *   │                │    │                │    │                │
 *   │ + restore()    │◄───│                │───►│ + get()        │
 *   │   ← Memento    │    │                │    │   → 取出       │
 *   └────────────────┘    └────────────────┘    └────────────────┘
 *
 *   关键约束：Caretaker 只能操作 Memento，不能读取其内部内容
 *             Originator 才能读取 Memento 的内容来恢复自己
 * </pre>
 *
 * <h2>备忘录的访问控制（封装性保障）</h2>
 * <p>备忘录中的状态应该是<strong>只能由 Originator 读取</strong>的：</p>
 * <ul>
 *   <li>Memento 的字段设为 private / package-private</li>
 *   <li>Originator 和 Memento 放在同一个包内，可以访问 package-private 字段</li>
 *   <li>外部代码只能持有 Memento 的引用，无法读取其内容</li>
 * </ul>
 *
 * <h2>业务场景</h2>
 * <ul>
 *   <li>编辑器：文档编辑的撤销/重做功能</li>
 *   <li>数据库：事务回滚时保存的数据库快照</li>
 *   <li>游戏：存档/读档、关卡回退</li>
 *   <li>IDE：代码编辑的历史记录</li>
 * </ul>
 *
 * @see patterns.behavioral.memento 备忘录模式示例
 */
package patterns.behavioral.memento;
