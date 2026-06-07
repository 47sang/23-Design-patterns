package patterns.structural.composite;

/**
 * 菜单项（叶子 / Leaf）
 *
 * <p>组合模式中的叶子节点，表示具体的菜品。
 * 叶子节点不能再包含子组件，因此不声明 add/remove 方法。</p>
 *
 * <h2>叶子节点的特点</h2>
 * <ul>
 *   <li>是树形结构中最末端的节点，没有子节点</li>
 *   <li>实现 MenuComponent 的所有抽象方法</li>
 *   <li>不提供 add/remove 方法，保证接口安全</li>
 * </ul>
 *
 * @see MenuComponent 抽象组件
 * @see Menu 容器节点
 */
class MenuItem extends MenuComponent {

    /**
     * 菜品名称。
     */
    private final String name;

    /**
     * 菜品价格。
     */
    private final double price;

    /**
     * 构造器：创建一个菜单项。
     *
     * @param name  菜品名称
     * @param price 菜品价格（元）
     */
    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.printf("  菜品：%s  ￥%.2f%n", name, price);
    }
}
