/**
 * 创建型模式（Creational Patterns）
 *
 * <p>创建型模式关注<strong>对象的创建过程</strong>，将对象的创建与使用分离，
 * 提高系统的灵活性和可维护性。</p>
 *
 * <p>创建型模式一共包含 6 种：</p>
 * <ul>
 *   <li>{@link patterns.creational.factory.simple} —— <strong>简单工厂模式</strong>：
 *       通过一个工厂类创建各种产品对象，客户端不需要知道具体产品类的创建逻辑。
 *       适用于产品种类不多且相对固定的场景。</li>
 *   <li>{@link patterns.creational.factory.method} —— <strong>工厂方法模式</strong>：
 *       定义一个创建对象的接口，让子类决定实例化哪一个类。
 *       工厂方法让类的实例化推迟到子类，符合开闭原则。</li>
 *   <li>{@link patterns.creational.factory.abstract_factory} —— <strong>抽象工厂模式</strong>：
 *       提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 *       适用于"产品族"的场景。</li>
 *   <li>{@link patterns.creational.builder} —— <strong>建造者模式</strong>：
 *       将复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示。
 *       适用于包含大量可选参数的复杂对象构建。</li>
 *   <li>{@link patterns.creational.singleton} —— <strong>单例模式</strong>：
 *       确保一个类仅有一个实例，并提供一个访问它的全局访问点。
 *       适用于全局唯一的资源（如配置管理器、连接池）。</li>
 *   <li>{@link patterns.creational.prototype} —— <strong>原型模式</strong>：
 *       用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。
 *       适用于创建成本较高的对象。</li>
 * </ul>
 *
 * <p><strong>核心思想</strong>：通过抽象化的方式封装对象的创建逻辑，
 * 使系统不依赖于具体类的实例化过程。</p>
 *
 */
package patterns.creational;
