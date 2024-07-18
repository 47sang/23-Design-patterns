package B.b;

/**
 * 波波芋圆奶茶
 * @author 周士钰
 * @date 2024/6/19 下午11:32
 */
public class KissTea extends RefinedAbstractTea{

    protected KissTea(Size size) {
        super(size);
    }

    @Override
    public String getType() {
        return "啵啵芋圆奶茶";
    }
}
