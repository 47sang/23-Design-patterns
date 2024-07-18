package B.b;

/**
 * 原始属性
 * @author 周士钰
 * @date 2024/6/19 下午11:27
 */
public abstract class AbstractTea {

    protected Size size;

    protected AbstractTea(Size size) {
        this.size = size;
    }

    public abstract String getType();
}
