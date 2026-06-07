package patterns.behavioral.visitor;

/**
 * 奖品元素接口（PrizeElement）— 访问者模式中的元素角色。
 *
 * <h2>设计意图</h2>
 * <p>定义一个接受访问者的接口。每个具体奖品元素实现此接口，
 * 在 {@link #accept(PrizeVisitor)} 方法中调用访问者的对应方法，
 * 实现双分派（Double Dispatch）。</p>
 *
 * <h2>双分派机制说明</h2>
 * <p>双分派是访问者模式的核心机制。整个过程分两步：</p>
 * <ol>
 *   <li><strong>第一次分派</strong>：客户端调用 {@code element.accept(visitor)}，
 *       Java 根据 element 的实际类型（运行时类型）来选择调用哪个 accept 方法。
 *       这是面向对象语言内置的单分派机制（基于接收者类型）。</li>
 *   <li><strong>第二次分派</strong>：在 accept 方法内部，
 *       调用 {@code visitor.visit(this)}，
 *       Java 根据 visitor 的实际类型和 {@code this} 的实际类型，
 *       选择调用 visitor 的哪个 {@code visit()} 重载方法。
 *       这就是双分派：先根据元素类型，再根据访问者类型。</li>
 * </ol>
 *
 * <p>双分派使得我们可以在不修改元素类的前提下，
 * 为元素添加新的操作（只需添加新的访问者类）。</p>
 *
 * <h2>与 PrizeVisitor 的关系</h2>
 * <p>PrizeElement 和 PrizeVisitor 是相互依赖的：
 * PrizeElement 调用 PrizeVisitor 的 visit 方法，
 * PrizeVisitor 调用 PrizeElement 的 getter 方法获取数据。
 * 这种双向依赖是访问者模式的固有特征。</p>
 *
 */
public interface PrizeElement {

    /**
     * 接受访问者 — 双分派的第一层。
     *
     * <p>元素调用访问者的 visit 方法，将自己传递给访问者，
     * 让访问者根据自己的具体类型执行相应的操作。</p>
     *
     * <p>具体元素类在实现此方法时，会调用
     * {@code visitor.visit(this)}，
     * 这里的 {@code this} 就是具体元素类型的实例，
     * 从而触发访问者中对应具体元素类型的 visit 重载方法。</p>
     *
     * @param visitor 要接受的访问者
     */
    void accept(PrizeVisitor visitor);
}
