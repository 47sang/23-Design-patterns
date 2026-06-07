package patterns.structural.bridge;

/**
 * 桥接模式演示入口
 *
 * <p>演示饮品类型 × 规格大小的组合，
 * 展示桥接模式如何避免类爆炸问题。</p>
 *
 * <h2>核心演示点</h2>
 * <ol>
 *   <li>2 种饮品 × 3 种规格 = 6 种组合，但只需要 5 个类（2 个饮品 + 3 个规格）</li>
 *   <li>新增饮品只需新增一个类，新增规格也只需新增一个类</li>
 *   <li>不会出现类爆炸（如继承方案需要 2×3=6 个具体类）</li>
 * </ol>
 *
 * <h2>如果不用桥接模式（继承方案）</h2>
 * <pre>
 * KissTeaLarge, KissTeaMedium, KissTeaSmall,
 * IceTeaLarge, IceTeaMedium, IceTeaSmall
 * → 6 个类，每新增一种饮品就要加 3 个类
 * </pre>
 *
 * <h2>使用桥接模式</h2>
 * <pre>
 * KissTea, IceTea（2 个抽象类）
 * Large, Medium, Small（3 个实现类）
 * → 5 个类，新增饮品/规格各只需 1 个类
 * </pre>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 桥接模式演示 ==========");
        System.out.println();

        // 定义三种规格
        Size small = new Small();
        Size medium = new Medium();
        Size large = new Large();

        // 定义两种饮品，分别搭配三种规格
        Beverage[] beverages = {
            new KissTea(small),
            new KissTea(medium),
            new KissTea(large),
            new IceTea(small),
            new IceTea(medium),
            new IceTea(large)
        };

        System.out.println("--- 所有饮品组合 ---");
        for (Beverage beverage : beverages) {
            System.out.printf("%s  ￥%.2f%n", beverage.getDescription(), beverage.getPrice());
        }

        System.out.println();
        System.out.println("========== 桥接模式优势 ==========");
        System.out.println("当前：2 种饮品 × 3 种规格 = 6 种组合，但仅需 5 个类");
        System.out.println("  - 饮品类：KissTea、IceTea（2 个）");
        System.out.println("  - 规格类：Small、Medium、Large（3 个）");
        System.out.println();
        System.out.println("若新增一种饮品（如\"柠檬茶\"）：只需新增 1 个类 -> 3x3=9 种组合");
        System.out.println("若新增一种规格（如\"超大杯\"）：只需新增 1 个类 -> 2x4=8 种组合");
        System.out.println("→ 绝不会出现类爆炸问题！");
    }
}
