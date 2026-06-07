package patterns.structural.composite;

/**
 * 菜单组件（抽象组件 / Component）
 *
 * <p>组合模式中的抽象组件，定义了菜单项和子菜单的统一接口。
 * 客户端通过此接口操作单个菜品和整个菜单树，无需区分叶子节点和容器节点。</p>
 *
 * <h2>安全组合 vs 透明组合</h2>
 * <p>本项目采用<strong>安全组合</strong>：</p>
 * <ul>
 *   <li><strong>MenuComponent</strong>：只声明通用操作方法（getName, getPrice, print）</li>
 *   <li><strong>MenuItem</strong>（叶子）：不声明 add/remove，因为叶子不能有子节点</li>
 *   <li><strong>Menu</strong>（容器）：声明 add/remove，因为容器可以有子节点</li>
 * </ul>
 *
 * <h2>安全组合的优点</h2>
 * <ul>
 *   <li>接口更安全：叶子节点不会有不安全的 add/remove 方法</li>
 *   <li>语义更清晰：一看就知道哪些类可以包含子节点</li>
 * </ul>
 *
 * <h2>安全组合的缺点</h2>
 * <ul>
 *   <li>失去了透明性：客户端需要判断当前操作的是 Menu 还是 MenuItem</li>
 *   <li>在使用 add/remove 时需要类型判断或依赖具体类</li>
 * </ul>
 *
 * @see MenuItem 叶子节点
 * @see Menu 容器节点
 */
abstract class MenuComponent {

    /**
     * 获取组件名称。
     *
     * @return 组件名称
     */
    public abstract String getName();

    /**
     * 获取组件价格。
     *
     * <p>对于叶子节点（菜品），返回菜品价格；
     * 对于容器节点（菜单），可以返回平均价格或总价。</p>
     *
     * @return 组件价格（元）
     */
    public abstract double getPrice();

    /**
     * 打印组件信息。
     *
     * <p>对于叶子节点，打印菜品信息；
     * 对于容器节点，递归打印所有子组件。</p>
     */
    public abstract void print();
}
