package B.b;

/**
 * 冰茶
 * @author 周士钰
 * @date 2024/6/19 下午11:41
 */
public class IceTea extends RefinedAbstractTea{
    protected IceTea(Size size) {
        super(size);
    }

    @Override
    public String getType() {
        return "冰茶";
    }
}
