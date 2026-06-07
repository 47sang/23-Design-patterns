package patterns.creational.builder;

/**
 * 建造者模式演示入口
 *
 * <h2>演示内容</h2>
 * <ol>
 *   <li>展示 telescoping constructor 问题（传统构造方式的困境）</li>
 *   <li>展示建造者模式的链式调用写法</li>
 *   <li>演示 build() 方法的参数校验</li>
 *   <li>对比两种方式的优劣</li>
 * </ol>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== 建造者模式演示 =====");
        System.out.println();

        // 1. 使用建造者模式创建订单（仅设置必填字段）
        System.out.println("--- 方式一：仅设置必填字段 ---");
        Order order1 = Order.builder()
                .userId("U10086")
                .productId("P20250607")
                .build();
        order1.printSummary();
        System.out.println();

        // 2. 链式调用设置所有字段
        System.out.println("--- 方式二：链式调用设置全部字段 ---");
        Order order2 = Order.builder()
                .userId("U10010")
                .productId("P20250608")
                .quantity(3)
                .address("北京市海淀区中关村大街1号")
                .remark("请尽快发货，谢谢")
                .couponCode("SAVE20")
                .build();
        order2.printSummary();
        System.out.println();

        // 3. 演示参数校验 — 缺少必填字段
        System.out.println("--- 方式三：build() 参数校验（缺少必填字段） ---");
        try {
            Order.builder()
                    .productId("P99999")  // 缺少 userId
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("  ✅ 捕获预期异常: " + e.getMessage());
        }
        System.out.println();

        // 4. 演示参数校验 — 无效数量
        System.out.println("--- 方式四：build() 参数校验（无效数量） ---");
        try {
            Order.builder()
                    .userId("U99999")
                    .productId("P99999")
                    .quantity(0)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("  ✅ 捕获预期异常: " + e.getMessage());
        }
        System.out.println();

        // 5. 对比 telescoping constructor 问题
        System.out.println("--- Telescoping Constructor 问题 ---");
        System.out.println("传统写法：");
        System.out.println("  new Order(\"U001\", \"P001\", 2, \"地址\", \"备注\", \"COUPON\");");
        System.out.println("  → 参数列表过长，容易传错顺序，难以阅读");
        System.out.println();
        System.out.println("建造者写法：");
        System.out.println("  Order.builder()");
        System.out.println("      .userId(\"U001\")");
        System.out.println("      .productId(\"P001\")");
        System.out.println("      .quantity(2)");
        System.out.println("      .build();");
        System.out.println("  → 每个参数有明确的方法名，链式调用清晰优雅");
    }
}
