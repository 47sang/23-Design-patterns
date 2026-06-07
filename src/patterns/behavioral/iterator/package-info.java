/**
 * 迭代器模式（Iterator Pattern）
 *
 * <h2>模式说明</h2>
 * <p>提供一种方法顺序访问一个聚合对象中的各个元素，
 * 而又不暴露该对象的内部表示。</p>
 *
 * <h2>为什么需要迭代器？</h2>
 * <p>如果没有迭代器，客户端需要知道集合的内部结构才能遍历：</p>
 * <pre>
 * // 没有迭代器：客户端必须知道数组的内部结构
 * for (int i = 0; i < array.length; i++) {
 *     System.out.println(array[i]);
 * }
 *
 * // 有了迭代器：客户端只需要调用 next()，不需要知道底层是数组还是链表
 * Iterator it = collection.iterator();
 * while (it.hasNext()) {
 *     System.out.println(it.next());
 * }
 * </pre>
 *
 * <h2>结构</h2>
 * <pre>
 *   ┌──────────────────────┐
 *   │   Iterator           │  ← 迭代器接口
 *   │  + hasNext()         │
 *   │  + next()            │
 *   │  + remove() (可选)   │
 *   └──────────────────────┘
 *
 *   ┌──────────────────────┐
 *   │  Iterable            │  ← 可迭代接口
 *   │  + iterator()        │  ← 返回一个 Iterator
 *   └──────────────────────┘
 *          ▲ 实现
 *   ┌──────┴──────────┐
 *   │  MyCollection   │  ← 自定义集合
 *   │  + iterator()   │     返回内部 Iterator 实现
 *   └─────────────────┘
 * </pre>
 *
 * <h2>内部迭代器 vs 外部迭代器</h2>
 * <ul>
 *   <li><strong>外部迭代器</strong>（Java 的 Iterator）：
 *       客户端控制遍历过程（调用 hasNext/next），灵活性高</li>
 *   <li><strong>内部迭代器</strong>（Java 8 forEach）：
 *       集合内部控制遍历过程，客户端只需提供动作</li>
 * </ul>
 *
 * <h2>Java 中的应用</h2>
 * <ul>
 *   <li>{@code java.util.Iterator} —— 所有集合类的迭代器</li>
 *   <li>{@code java.util.ListIterator} —— 支持双向遍历的迭代器</li>
 *   <li>增强 for 循环（for-each）—— 编译器自动转换为 Iterator 调用</li>
 *   <li>Stream API —— 基于内部迭代器的函数式遍历</li>
 * </ul>
 *
 * @see patterns.behavioral.iterator 迭代器模式示例（自定义集合 + 自定义迭代器）
 */
package patterns.behavioral.iterator;
