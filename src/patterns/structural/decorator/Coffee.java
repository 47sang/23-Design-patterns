package patterns.structural.decorator;

/**
 * 咖啡（抽象组件 / Component）
 *
 * <p>装饰模式中的抽象组件，定义了咖啡的核心接口。
 * 所有具体咖啡和装饰器都继承/实现此接口，
 * 使得装饰器可以透明地包装任何 Coffee 对象。</p>
 *
 * <h2>装饰模式的核心机制</h2>
 * <p>抽象组件（Coffee）定义了被装饰对象的接口。
 * 装饰器（Decorator）也继承/实现此接口，
 * 并持有一个被装饰的 Coffee 对象引用。
 * 这样装饰器既可以"是一个"Coffee（符合接口），
 * 又可以"包装一个"Coffee（通过组合）。</p>
 *
 * <h2>装饰器链</h2>
 * <pre>
 * Coffee coffee = new SimpleCoffee();          // 基础咖啡 ￥20
 * coffee = new MilkDecorator(coffee);          // +牛奶 ￥25
 * coffee = new SugarDecorator(coffee);         // +糖 ￥27
 * coffee = new WhipCreamDecorator(coffee);     // +奶油 ￥32
 * System.out.println(coffee.getDescription()); // "咖啡, 牛奶, 糖, 奶油"
 * System.out.println(coffee.cost());           // 32.0
 * </pre>
 *
 * @see SimpleCoffee 基础咖啡
 * @see MilkDecorator 牛奶装饰器
 * @see SugarDecorator 糖装饰器
 * @see WhipCreamDecorator 奶油装饰器
 */
abstract class Coffee {

    /**
     * 获取咖啡描述。
     *
     * <p>描述包含咖啡本身以及所有装饰器的名称。
     * 每个装饰器会在描述中追加自己的名称。</p>
     *
     * @return 咖啡的完整描述
     */
    public abstract String getDescription();

    /**
     * 计算咖啡价格。
     *
     * <p>价格包含咖啡本身以及所有装饰器的价格。
     * 每个装饰器会在价格中加上自己的价格。</p>
     *
     * @return 咖啡的总价格（元）
     */
    public abstract double cost();
}
