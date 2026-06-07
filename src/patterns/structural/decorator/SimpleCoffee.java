package patterns.structural.decorator;

/**
 * 基础咖啡（具体组件 / Concrete Component）
 *
 * <p>装饰模式中最基础的具体组件，不包含任何装饰器。
 * 这是装饰链的起点，所有装饰器都包装在这个基础对象之上。</p>
 *
 * <h2>与装饰器的关系</h2>
 * <p>SimpleCoffee 是被装饰的"核心"，
 * MilkDecorator、SugarDecorator、WhipCreamDecorator 都是"附加"在核心之上的装饰。
 * 这种设计使得新增装饰器不需要修改 SimpleCoffee 的代码，
 * 符合开闭原则。</p>
 *
 * @see Coffee 抽象咖啡组件
 * @see MilkDecorator 牛奶装饰器
 * @see SugarDecorator 糖装饰器
 * @see WhipCreamDecorator 奶油装饰器
 */
class SimpleCoffee extends Coffee {

    /**
     * 基础咖啡的描述。
     */
    private static final String DESCRIPTION = "咖啡";

    /**
     * 基础咖啡的价格（元）。
     */
    private static final double PRICE = 20.0;

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public double cost() {
        return PRICE;
    }
}
