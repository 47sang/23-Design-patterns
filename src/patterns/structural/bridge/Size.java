package patterns.structural.bridge;

/**
 * 规格接口（Implementor）
 *
 * <p>桥接模式中的<strong>实现部分</strong>接口，
 * 定义了饮品规格的抽象行为。</p>
 *
 * <h2>桥接模式的两个维度</h2>
 * <ul>
 *   <li><strong>抽象维度</strong>：Beverage（饮品类型）—— KissTea、IceTea 等</li>
 *   <li><strong>实现维度</strong>：Size（规格大小）—— Small、Medium、Large 等</li>
 * </ul>
 *
 * <p>两个维度独立变化：新增饮品只需新增一个 Beverage 子类，
 * 新增规格只需新增一个 Size 实现类，不会产生类爆炸。</p>
 *
 * <h2>与继承方案的对比</h2>
 * <p>如果使用继承而非桥接：
 * <pre>
 * KissTeaLarge, KissTeaMedium, KissTeaSmall,
 * IceTeaLarge, IceTeaMedium, IceTeaSmall, ...
 * → M 种饮品 × N 种规格 = M×N 个类
 * </pre>
 * 使用桥接模式后：
 * <pre>
 * M 个 Beverage 子类 + N 个 Size 实现类 = M+N 个类
 * </pre>
 * </p>
 *
 * @see Beverage 抽象饮品（持有 Size 引用）
 */
interface Size {

    /**
     * 获取规格描述。
     *
     * @return 规格的文字描述，如"小杯"、"中杯"、"大杯"
     */
    String getDescription();
}
