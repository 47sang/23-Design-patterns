package patterns.structural.decorator;

/**
 * 牛奶装饰器（具体装饰器 / Concrete Decorator）
 *
 * <p>为咖啡添加牛奶调味，在基础价格上增加 5 元。</p>
 *
 * <h2>装饰器的工作机制</h2>
 * <ol>
 *   <li>持有一个被装饰的 Coffee 对象引用（组合关系）</li>
 *   <li>在 getDescription() 中，先调用被装饰对象的描述，再追加自己的描述</li>
 *   <li>在 cost() 中，先调用被装饰对象的价格，再加上自己的价格</li>
 * </ol>
 *
 * <p>这样层层嵌套，形成一条装饰链，
 * 最终描述和价格会累积所有装饰器的效果。</p>
 *
 * @see Coffee 抽象咖啡组件
 * @see SugarDecorator 糖装饰器
 * @see WhipCreamDecorator 奶油装饰器
 */
class MilkDecorator extends Coffee {

    /**
     * 被装饰的咖啡对象。
     *
     * <p>通过这个引用，装饰器可以委托被装饰对象完成核心逻辑，
     * 并在其基础上添加自己的行为。</p>
     */
    private final Coffee coffee;

    /**
     * 牛奶的价格（元）。
     */
    private static final double MILK_PRICE = 5.0;

    /**
     * 构造器：传入需要装饰的咖啡对象。
     *
     * @param coffee 被装饰的咖啡对象（可以是基础咖啡，也可以是已被其他装饰器装饰的咖啡）
     */
    MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        // 先获取被装饰对象的描述，再追加自己的描述
        return coffee.getDescription() + ", 牛奶";
    }

    @Override
    public double cost() {
        // 在被装饰对象的价格基础上加上牛奶的价格
        return coffee.cost() + MILK_PRICE;
    }
}
