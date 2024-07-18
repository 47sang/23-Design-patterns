package B.c;

/**
 * 组件抽象
 *
 * @author 周士钰
 * @date 2024/7/18 下午9:50
 */
public abstract class Component {
    /**
     * 添加子组件
     * @param component
     */
    public abstract void addComponent(Component component);

    /**
     * 删除子组件
     * @param component
     */
    public abstract void removeComponent(Component component);

    /**
     * 获取子组件
     * @param inedx
     * @return
     */
    public abstract Component getChild(int inedx);

    /**
     * 执行对应的业务方法，比如修改文件名称
     */
    public abstract void changeName();
}
