package patterns.structural.decorator;

/**
 * 装饰模式演示入口
 *
 * <p>演示咖啡订单 + 多种调料装饰的价格计算过程，
 * 展示装饰器链的灵活组合方式。</p>
 *
 * <h2>演示流程</h2>
 * <ol>
 *   <li>基础咖啡：SimpleCoffee，价格 ￥20</li>
 *   <li>逐步添加装饰器，展示价格累积过程</li>
 *   <li>最终演示完整装饰链：SimpleCoffee + Milk + Sugar + WhipCream</li>
 * </ol>
 *
 * <h2>价格计算过程</h2>
 * <pre>
 * SimpleCoffee          : ￥20
 * + MilkDecorator       : +￥5  → ￥25
 * + SugarDecorator      : +￥2  → ￥27
 * + WhipCreamDecorator  : +￥7  → ￥34
 * </pre>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 装饰模式演示：咖啡订单 ==========");
        System.out.println();

        // ========== 逐步添加装饰器 ==========
        System.out.println("--- 逐步构建装饰链 ---");

        // 步骤 1：基础咖啡
        Coffee coffee = new SimpleCoffee();
        System.out.printf("步骤 1：基础咖啡  -> %s  ￥%.2f%n", coffee.getDescription(), coffee.cost());

        // 步骤 2：加牛奶
        coffee = new MilkDecorator(coffee);
        System.out.printf("步骤 2：加牛奶    -> %s  ￥%.2f  (牛奶 +￥5)%n", coffee.getDescription(), coffee.cost());

        // 步骤 3：加糖
        coffee = new SugarDecorator(coffee);
        System.out.printf("步骤 3：加糖      -> %s  ￥%.2f  (糖 +￥2)%n", coffee.getDescription(), coffee.cost());

        // 步骤 4：加奶油
        coffee = new WhipCreamDecorator(coffee);
        System.out.printf("步骤 4：加奶油    -> %s  ￥%.2f  (奶油 +￥7)%n", coffee.getDescription(), coffee.cost());

        System.out.println();

        // ========== 其他组合示例 ==========
        System.out.println("--- 其他装饰组合示例 ---");

        // 示例 1：只加牛奶和奶油
        Coffee combo1 = new WhipCreamDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.printf("咖啡 + 牛奶 + 奶油：%s  ￥%.2f%n", combo1.getDescription(), combo1.cost());

        // 示例 2：只加糖
        Coffee combo2 = new SugarDecorator(new SimpleCoffee());
        System.out.printf("咖啡 + 糖：        %s  ￥%.2f%n", combo2.getDescription(), combo2.cost());

        // 示例 3：全加（与上面等价，但顺序不同）
        Coffee combo3 = new SimpleCoffee();
        combo3 = new MilkDecorator(combo3);
        combo3 = new SugarDecorator(combo3);
        combo3 = new WhipCreamDecorator(combo3);
        System.out.printf("全加（另一写法）：%s  ￥%.2f%n", combo3.getDescription(), combo3.cost());

        System.out.println();
        System.out.println("========== 装饰模式优势 ==========");
        System.out.println("1. 比继承更灵活：不需要为每种调料组合创建子类");
        System.out.println("2. 符合开闭原则：新增装饰器无需修改已有代码");
        System.out.println("3. 避免类爆炸：N 种调料只需 N 个装饰器，而非 2^N 个子类");
        System.out.println("4. 装饰器可以任意组合，顺序也可以灵活调整");
    }
}
