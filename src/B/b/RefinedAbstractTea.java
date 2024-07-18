package B.b;

/**
 * 拓展属性-维度
 * @author 周士钰
 * @date 2024/6/19 下午11:31
 */
public abstract class RefinedAbstractTea extends AbstractTea {
    protected RefinedAbstractTea(Size size) {
        super(size);
    }

    //添加尺寸维度获取方式
    public String getSize(){
        return size.getSize();
    }

}
