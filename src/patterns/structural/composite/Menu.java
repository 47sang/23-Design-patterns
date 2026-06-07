package patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单（容器 / Composite）
 *
 * <p>组合模式中的容器节点，可以包含多个菜单项（MenuItem）或子菜单（Menu）。
 * 容器节点通过递归调用子组件的 print() 方法，实现对整个树形结构的统一打印。</p>
 *
 * <h2>容器节点的特点</h2>
 * <ul>
 *   <li>可以包含任意多个 MenuComponent（叶子或容器）</li>
 *   <li>声明 add/remove 方法，管理子组件</li>
 *   <li>实现 print() 时，先打印自己，再递归调用所有子组件的 print()</li>
 * </ul>
 *
 * <h2>递归打印流程</h2>
 * <pre>
 * Menu.print() {
 *     打印自己的名称
 *     for each child : children
 *         child.print()  // 递归调用，子组件可能是 Menu 或 MenuItem
 * }
 * </pre>
 *
 * @see MenuComponent 抽象组件
 * @see MenuItem 叶子节点
 */
class Menu extends MenuComponent {

    /**
     * 菜单名称。
     */
    private final String name;

    /**
     * 子组件列表（可以是 MenuItem 或子 Menu）。
     *
     * <p>使用 List 存储子组件，通过 add/remove 管理。</p>
     */
    private final List<MenuComponent> children = new ArrayList<>();

    /**
     * 构造器：创建一个菜单。
     *
     * @param name 菜单名称
     */
    Menu(String name) {
        this.name = name;
    }

    /**
     * 添加子组件（菜品或子菜单）。
     *
     * <p>在安全组合中，add/remove 只在容器节点（Menu）中声明，
     * 叶子节点（MenuItem）不提供此方法，保证了接口的安全性。</p>
     *
     * @param component 要添加的子组件
     */
    public void add(MenuComponent component) {
        children.add(component);
    }

    /**
     * 移除子组件。
     *
     * @param component 要移除的子组件
     */
    public void remove(MenuComponent component) {
        children.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        // 返回所有子组件的平均价格
        if (children.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (MenuComponent child : children) {
            total += child.getPrice();
        }
        return total / children.size();
    }

    @Override
    public void print() {
        System.out.println("=== " + name + " ===");
        // 递归打印所有子组件
        for (MenuComponent child : children) {
            child.print();
        }
    }
}
