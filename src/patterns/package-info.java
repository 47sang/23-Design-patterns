/**
 * Java 设计模式详解 —— 根包
 *
 * <p>本包为项目根包，涵盖 GoF（Gang of Four）23 种经典设计模式的完整实现与讲解。</p>
 *
 * <h2>设计原则基础</h2>
 * <p>在学习具体的设计模式之前，我们需要先了解面向对象设计的七大原则，
 * 这些原则是设计模式的理论基础：</p>
 * <ul>
 *   <li><strong>单一职责原则（SRP）</strong>：一个类应该只有一个引起它变化的原因</li>
 *   <li><strong>开闭原则（OCP）</strong>：软件实体应当对扩展开放，对修改关闭</li>
 *   <li><strong>里氏替换原则（LSP）</strong>：子类可以扩展父类的功能，但不能改变父类原有的功能</li>
 *   <li><strong>依赖倒转原则（DIP）</strong>：高层模块不应依赖于底层模块，它们都应该依赖抽象</li>
 *   <li><strong>接口隔离原则（ISP）</strong>：客户端不应依赖那些它不需要的接口</li>
 *   <li><strong>合成复用原则（CRP）</strong>：优先使用对象组合，而不是通过继承来达到复用的目的</li>
 *   <li><strong>迪米特法则（LoD）</strong>：一个对象应该对其他对象保持最少的了解</li>
 * </ul>
 *
 * <h2>包结构</h2>
 * <ul>
 *   <li>{@code patterns.creational} —— 创建型模式：关注对象的创建过程</li>
 *   <li>{@code patterns.structural} —— 结构型模式：关注类和对象的组合</li>
 *   <li>{@code patterns.behavioral} —— 行为型模式：关注对象之间的通信和职责分配</li>
 * </ul>
 *
 * <h2>学习建议</h2>
 * <p>初学者从创建型模式入门，理解对象创建的抽象；重点攻克装饰器和代理模式；
 * 从观察者和策略模式开始学行为型模式；进阶时分析 Spring 等框架中的模式应用。</p>
 *
 */
package patterns;
