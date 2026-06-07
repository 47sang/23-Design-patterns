/**
 * 结构型模式（Structural Patterns）
 *
 * <p>结构型模式关注<strong>类和对象的组合</strong>，通过组合获得更大的结构，
 * 同时保持结构的灵活和高效。</p>
 *
 * <p>结构型模式一共包含 7 种：</p>
 * <ul>
 *   <li>{@link patterns.structural.adapter} —— <strong>适配器模式</strong>：
 *       将一个类的接口转换成客户希望的另一个接口，使不兼容的类可以一起工作。</li>
 *   <li>{@link patterns.structural.bridge} —— <strong>桥接模式</strong>：
 *       将抽象部分与实现部分分离，使它们都可以独立地变化。</li>
 *   <li>{@link patterns.structural.composite} —— <strong>组合模式</strong>：
 *       将对象组合成树形结构以表示"部分-整体"的层次结构，
 *       使用户对单个对象和组合对象的使用具有一致性。</li>
 *   <li>{@link patterns.structural.decorator} —— <strong>装饰模式</strong>：
 *       动态地给一个对象添加额外的职责，比生成子类更灵活。</li>
 *   <li>{@link patterns.structural.proxy} —— <strong>代理模式</strong>：
 *       为其他对象提供一种代理以控制对这个对象的访问。</li>
 *   <li>{@link patterns.structural.facade} —— <strong>外观模式</strong>：
 *       为子系统中一组接口提供一致的界面，使子系统更易使用。</li>
 *   <li>{@link patterns.structural.flyweight} —— <strong>享元模式</strong>：
 *       运用共享技术有效地支持大量细粒度的对象。</li>
 * </ul>
 *
 * <p><strong>核心思想</strong>：通过组合而非继承来扩展功能，
 * 降低类之间的耦合度，提高系统的灵活性。</p>
 *
 */
package patterns.structural;
