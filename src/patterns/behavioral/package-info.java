/**
 * 行为型模式（Behavioral Patterns）
 *
 * <p>行为型模式关注<strong>对象之间的通信和职责分配</strong>，
 * 描述对象之间怎样协作完成单个对象无法独立完成的任务。</p>
 *
 * <p>行为型模式一共包含 11 种：</p>
 * <ul>
 *   <li>{@link patterns.behavioral.interpreter} —— <strong>解释器模式</strong>：
 *       给定一个语言，定义它的文法的一种表示，并定义一个解释器来解释语言中的句子。</li>
 *   <li>{@link patterns.behavioral.template_method} —— <strong>模板方法模式</strong>：
 *       定义操作中的算法骨架，将一些步骤延迟到子类中实现。</li>
 *   <li>{@link patterns.behavioral.chain_of_responsibility} —— <strong>责任链模式</strong>：
 *       为请求创建一条接收者对象的链，将请求发送者和接收者解耦。</li>
 *   <li>{@link patterns.behavioral.command} —— <strong>命令模式</strong>：
 *       将请求封装为对象，支持请求的排队、记录和撤销。</li>
 *   <li>{@link patterns.behavioral.iterator} —— <strong>迭代器模式</strong>：
 *       提供一种方法顺序访问聚合对象中的元素，不暴露内部结构。</li>
 *   <li>{@link patterns.behavioral.mediator} —— <strong>中介者模式</strong>：
 *       用一个中介对象来封装一系列对象之间的交互，降低耦合。</li>
 *   <li>{@link patterns.behavioral.memento} —— <strong>备忘录模式</strong>：
 *       在不破坏封装性的前提下，捕获对象的内部状态并在对象外保存。</li>
 *   <li>{@link patterns.behavioral.observer} —— <strong>观察者模式</strong>：
 *       定义对象间一对多的依赖关系，状态变化时自动通知所有观察者。</li>
 *   <li>{@link patterns.behavioral.state} —— <strong>状态模式</strong>：
 *       允许对象在内部状态改变时改变其行为，对象看起来像修改了它的类。</li>
 *   <li>{@link patterns.behavioral.strategy} —— <strong>策略模式</strong>：
 *       定义一系列算法，将它们封装起来并使它们可相互替换。</li>
 *   <li>{@link patterns.behavioral.visitor} —— <strong>访问者模式</strong>：
 *       在不改变元素类的前提下，定义作用于元素的新操作。</li>
 * </ul>
 *
 * <p><strong>核心思想</strong>：通过引入中间层来协调对象之间的交互，
 * 使对象之间的通信更加灵活、松耦合。</p>
 *
 */
package patterns.behavioral;
