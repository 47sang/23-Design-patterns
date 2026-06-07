package patterns.structural.decorator;

/**
 * 糖装饰器（具体装饰器 / Concrete Decorator）
 *
 * <p>为咖啡添加糖调味，在基础价格上增加 2 元。</p>
 *
 * <h2>装饰器链的灵活性</h2>
 * <p>糖装饰器可以装饰任何 Coffee 对象：
 * <pre>
 * new SugarDecorator(new SimpleCoffee())     // 咖啡 + 糖
 * new SugarDecorator(new MilkDecorator(...)) // 咖啡 + 牛奶 + 糖
 * </pre>
 * 这就是装饰模式比继承更灵活的原因——
 * 不需要为每种组合创建一个子类，装饰器可以任意组合。</p>
 *
 * @see Coffee 抽象咖啡组件
 * @see MilkDecorator 牛奶装饰器
 * @see WhipCreamDecorator 奶油装饰器
 */
class SugarDecorator extends Coffee {

    /**
     * 被装饰的咖啡对象。
     */
    private final Coffee coffee;

    /**
     * 糖的价格（元）。
     */
    private static final double SUGAR_PRICE = 2.0;

    /**
     * 构造器：传入需要装饰的咖啡对象。
     *
     * @param coffee 被装饰的咖啡对象
     */
    SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", 糖";
    }

    @Override
    public double cost() {
        return coffee.cost() + SUGAR_PRICE;
    }
}
