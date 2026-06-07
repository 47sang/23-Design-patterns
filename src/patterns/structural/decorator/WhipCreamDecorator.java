package patterns.structural.decorator;

/**
 * 奶油装饰器（具体装饰器 / Concrete Decorator）
 *
 * <p>为咖啡添加鲜奶油，在基础价格上增加 7 元。</p>
 *
 * <h2>装饰器链示例</h2>
 * <pre>
 * Coffee coffee = new SimpleCoffee();              // ￥20, "咖啡"
 * coffee = new MilkDecorator(coffee);              // ￥25, "咖啡, 牛奶"
 * coffee = new SugarDecorator(coffee);             // ￥27, "咖啡, 牛奶, 糖"
 * coffee = new WhipCreamDecorator(coffee);         // ￥34, "咖啡, 牛奶, 糖, 奶油"
 * </pre>
 *
 * <p>每个装饰器只关心自己的职责（加什么、加多少钱），
 * 不关心装饰链中还有其他什么装饰器。
 * 这就是单一职责原则的体现。</p>
 *
 * @see Coffee 抽象咖啡组件
 * @see MilkDecorator 牛奶装饰器
 * @see SugarDecorator 糖装饰器
 */
class WhipCreamDecorator extends Coffee {

    /**
     * 被装饰的咖啡对象。
     */
    private final Coffee coffee;

    /**
     * 奶油的价格（元）。
     */
    private static final double WHIP_CREAM_PRICE = 7.0;

    /**
     * 构造器：传入需要装饰的咖啡对象。
     *
     * @param coffee 被装饰的咖啡对象
     */
    WhipCreamDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", 奶油";
    }

    @Override
    public double cost() {
        return coffee.cost() + WHIP_CREAM_PRICE;
    }
}
