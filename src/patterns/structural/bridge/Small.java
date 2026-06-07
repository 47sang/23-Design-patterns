package patterns.structural.bridge;

/**
 * 小杯规格（Concrete Implementor）
 *
 * <p>实现 {@link Size} 接口，表示"小杯"规格。</p>
 *
 * <p>作为桥接模式中实现维度的具体实现，
 * 新增规格只需新增一个实现 Size 接口的类即可，
 * 不需要修改任何饮品类。</p>
 *
 */
class Small implements Size {

    @Override
    public String getDescription() {
        return "小杯";
    }
}
