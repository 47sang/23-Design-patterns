package B.c;

/**
 * 文件
 * @author 周士钰
 * @date 2024/7/18 下午9:55
 */
public class File extends Component {
    @Override
    public void addComponent(Component component) {
        throw new UnsupportedOperationException("文件类不支持添加子组件");
    }

    @Override
    public void removeComponent(Component component) {
        throw new UnsupportedOperationException("文件类不支持删除子组件");
    }

    @Override
    public Component getChild(int inedx) {
        throw new UnsupportedOperationException("文件类不支持获取子组件");
    }

    @Override
    public void changeName() {
        System.out.println("文件名称修改成功!" + this);
    }
}
