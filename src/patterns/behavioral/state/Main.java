package patterns.behavioral.state;

/**
 * 状态模式演示 — 订单状态流转。
 *
 * <h2>演示场景</h2>
 * <p>创建一个新订单，演示完整的订单生命周期：
 * 已创建 → 已支付 → 已发货 → 已签收</p>
 *
 * <h2>设计修复说明</h2>
 * <p>本实现修复了原代码中 null state 导致 NPE 的问题。
 * OrderContext 在构造时自动初始化为 CreatedState，
 * 确保不会出现 null state 的情况。</p>
 *
 * <h2>状态流转图</h2>
 * <pre>
 *   [已创建] --pay()--> [已支付] --ship()--> [已发货] --deliver()--> [已签收]
 *      |                   |                                        |
 *      |                   |--cancel()                              |
 *      |
 *   cancel(不支持)    cancel(退款)                             所有操作(不支持)
 * </pre>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 状态模式演示：订单状态流转 ==========");
        System.out.println();

        // ==================== 创建订单 ====================
        System.out.println("===== 创建订单 =====");
        OrderContext order = new OrderContext("ORD-2024-001");
        System.out.println("订单 " + order.getStateDescription() + "（初始状态）");
        System.out.println();

        // ==================== 正常流转：已创建 → 已支付 ====================
        System.out.println("===== 步骤1：支付订单 =====");
        order.pay();
        System.out.println("当前状态: " + order.getStateDescription());
        System.out.println();

        // ==================== 已支付 → 已发货 ====================
        System.out.println("===== 步骤2：发货 =====");
        order.ship();
        System.out.println("当前状态: " + order.getStateDescription());
        System.out.println();

        // ==================== 已发货 → 已签收 ====================
        System.out.println("===== 步骤3：签收 =====");
        order.deliver();
        System.out.println("当前状态: " + order.getStateDescription());
        System.out.println();

        // ==================== 已签收状态下所有操作都失败 ====================
        System.out.println("===== 步骤4：订单已完成，尝试各种操作 =====");
        order.pay();
        order.ship();
        order.deliver();
        order.cancel();
        System.out.println();

        // ==================== 演示第二个订单：取消流程 ====================
        System.out.println("===== 第二个订单：支付后取消 =====");
        OrderContext order2 = new OrderContext("ORD-2024-002");
        System.out.println("订单 " + order2.getStateDescription() + "（初始状态）");
        order2.pay();
        System.out.println("当前状态: " + order2.getStateDescription());
        order2.cancel();
        System.out.println();

        // ==================== 演示非法状态转换 ====================
        System.out.println("===== 第三个订单：测试非法操作 =====");
        OrderContext order3 = new OrderContext("ORD-2024-003");
        System.out.println("订单 " + order3.getStateDescription() + "（初始状态）");
        System.out.println("尝试未支付直接发货:");
        order3.ship();
        System.out.println("尝试未发货直接签收:");
        order3.deliver();
        System.out.println();

        System.out.println("========== 状态模式演示结束 ==========");
    }
}
