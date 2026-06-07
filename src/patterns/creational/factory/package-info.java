/**
 * 工厂模式包（Factory Patterns）
 *
 * <p>本包包含三种工厂模式的实现：</p>
 * <ul>
 *   <li>{@link patterns.creational.factory.simple} —— 简单工厂模式</li>
 *   <li>{@link patterns.creational.factory.method} —— 工厂方法模式</li>
 *   <li>{@link patterns.creational.factory.abstract_factory} —— 抽象工厂模式</li>
 * </ul>
 *
 * <p>三种工厂模式的演进关系：</p>
 * <pre>
 * 简单工厂：一个工厂类 + switch/if-else → 新增产品需要修改工厂类（违反开闭原则）
 *    ↓
 * 工厂方法：抽象工厂接口 + 多个工厂子类 → 新增产品只需新增工厂子类（符合开闭原则）
 *    ↓
 * 抽象工厂：抽象工厂接口 + 多个工厂子类（每个工厂创建一系列产品）→ 适用于产品族
 * </pre>
 *
 */
package patterns.creational.factory;
