/**
 * 工厂方法模式（Factory Method Pattern）
 *
 * <h2>模式说明</h2>
 * <p>工厂方法模式定义一个创建对象的接口，让子类决定实例化哪一个类。
 * 工厂方法让类的实例化推迟到子类，从而避免在客户端代码中直接使用 new。</p>
 *
 * <h2>与简单工厂的区别</h2>
 * <pre>
 * 简单工厂：工厂类自身包含 switch/if-else 判断 → 新增产品需要修改工厂类
 * 工厂方法：抽象工厂接口 + 每个产品对应一个工厂子类 → 新增产品只需新增工厂子类
 * </pre>
 *
 * <h2>结构</h2>
 * <pre>
 *              ┌──────────────────────┐
 *              │  FruitFactory        │  ← 抽象工厂（声明工厂方法）
 *              │  + getFruit()        │
 *              └──────────┬───────────┘
 *                         │ 继承
 *              ┌──────────┼───────────┐
 *              │          │           │
 *         ┌────┴───┐ ┌───┴────┐ ┌───┴────┐
 *         │Apple   │ │Banana  │ │Orange  │  ← 具体工厂，各自创建一种产品
 *         │Factory │ │Factory │ │Factory │
 *         └────────┘ └────────┘ └────────┘
 * </pre>
 *
 * <h2>核心思想</h2>
 * <p>将对象的创建延迟到子类中完成，客户端只依赖抽象工厂接口，
 * 不关心具体产品由哪个工厂创建。新增产品类型时，只需添加新的工厂子类，
 * 无需修改现有代码——符合<strong>开闭原则</strong>。</p>
 *
 * @see patterns.creational.factory.simple 简单工厂模式
 * @see patterns.creational.factory.abstract_factory 抽象工厂模式
 */
package patterns.creational.factory.method;
