package B.c;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件夹目录
 * @author 周士钰
 * @date 2024/7/18 下午9:52
 */
public class Directory extends Component{

    List<Component> child = new ArrayList<>();

    @Override
    public void addComponent(Component component) {
        child.add(component);
    }

    @Override
    public void removeComponent(Component component) {
        child.remove(component);
    }

    @Override
    public Component getChild(int inedx) {
        return child.get(inedx);
    }

    @Override
    public void changeName() {
        //将继续调用所有子组件的changeName方法执行业务
        child.forEach(Component::changeName);
    }
}
