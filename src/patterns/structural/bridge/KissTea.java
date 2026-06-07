package patterns.structural.bridge;

/**
 * 啵啵芋圆奶茶（Concrete Abstraction）
 *
 * <p>继承 {@link Beverage}，表示"啵啵芋圆奶茶"这一具体饮品类型。</p>
 *
 * <p>作为桥接模式中抽象维度的具体实现，
 * 新增饮品类型只需新增一个继承 Beverage 的类，
 * 不需要修改任何规格（Size）相关的代码。</p>
 *
 * @see Beverage 抽象饮品
 * @see Size 规格接口
 */
class KissTea extends Beverage {

    /**
     * 啵啵芋圆奶茶的基础价格（小杯价格）。
     */
    private static final double BASE_PRICE = 18.0;

    /**
     * 构造器：传入规格实现。
     *
     * @param size 饮品规格（小杯/中杯/大杯）
     */
    KissTea(Size size) {
        super(size);
    }

    @Override
    public String getDescription() {
        return "啵啵芋圆奶茶（" + size.getDescription() + "）";
    }

    @Override
    public double getPrice() {
        // 不同规格有不同的价格加成
        if (size instanceof Large) {
            return BASE_PRICE + 5.0;
        } else if (size instanceof Medium) {
            return BASE_PRICE + 3.0;
        }
        return BASE_PRICE;
    }
}
