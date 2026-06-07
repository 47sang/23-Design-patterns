package patterns.structural.bridge;

/**
 * 抽象饮品（Abstraction）
 *
 * <p>桥接模式中的<strong>抽象部分</strong>，
 * 持有实现部分 {@link Size} 的引用，
 * 将饮品的抽象行为委托给具体的规格实现。</p>
 *
 * <h2>桥接模式的核心机制</h2>
 * <p>抽象类（Beverage）持有一个实现接口（Size）的引用，
 * 抽象类中的方法可以委托给这个引用来执行具体操作。
 * 这样抽象部分和实现部分就可以独立变化。</p>
 *
 * <h2>独立变化的保证</h2>
 * <ul>
 *   <li>新增饮品类型：只需新增一个 Beverage 子类，无需修改 Size 相关代码</li>
 *   <li>新增规格：只需新增一个 Size 实现类，无需修改任何 Beverage 子类</li>
 * </ul>
 *
 * @see KissTea 啵啵芋圆奶茶
 * @see IceTea 冰茶
 * @see Size 规格接口
 */
abstract class Beverage {

    /**
     * 持有规格实现部分的引用（桥接的核心：组合实现接口）。
     *
     * <p>这个引用将抽象部分（饮品）与实现部分（规格）连接起来，
     * 使两者可以独立变化。</p>
     */
    protected final Size size;

    /**
     * 构造器：注入规格实现。
     *
     * <p>通过构造器注入 Size，符合依赖倒置原则——
     * 抽象类不依赖具体的规格实现，只依赖 Size 接口。</p>
     *
     * @param size 饮品规格实现
     */
    Beverage(Size size) {
        this.size = size;
    }

    /**
     * 获取饮品的完整描述。
     *
     * <p>组合饮品类型描述和规格描述，
     * 由子类提供饮品类型，由 Size 提供规格描述。</p>
     *
     * @return 饮品的完整描述，如"啵啵芋圆奶茶（大杯）"
     */
    public abstract String getDescription();

    /**
     * 获取饮品价格。
     *
     * <p>不同饮品基础价格不同，由子类实现；
     * 规格加成（如大杯加价）由 Size 维度决定。</p>
     *
     * @return 饮品价格（元）
     */
    public abstract double getPrice();
}
