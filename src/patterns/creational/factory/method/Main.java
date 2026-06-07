package patterns.creational.factory.method;

/**
 * 工厂方法模式演示入口
 *
 * <h2>演示内容</h2>
 * <ol>
 *   <li>通过不同的具体工厂创建不同支付渠道的处理器</li>
 *   <li>客户端只依赖抽象工厂 {@link PaymentProcessorFactory} 和抽象产品 {@link PaymentProcessor}</li>
 *   <li>展示"新增支付方式只需新增工厂类，不修改已有代码"的开闭原则优势</li>
 * </ol>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== 工厂方法模式演示 =====");
        System.out.println();

        // 客户端只依赖抽象工厂，不关心具体实现
        System.out.println("--- 使用支付宝 ---");
        PaymentProcessorFactory alipayFactory = new AlipayFactory();
        System.out.println(alipayFactory.processPayment("ORD-20250607-001", 99.9));
        System.out.println(alipayFactory.queryRefund("ORD-20250607-001", "REF-001"));
        System.out.println();

        System.out.println("--- 使用微信支付 ---");
        PaymentProcessorFactory wechatFactory = new WechatPayFactory();
        System.out.println(wechatFactory.processPayment("ORD-20250607-002", 49.5));
        System.out.println(wechatFactory.queryRefund("ORD-20250607-002", "REF-002"));
        System.out.println();

        // 展示开闭原则：新增支付方式只需加工厂类
        System.out.println("--- 新增支付方式（如银联）只需新增 UnionPayFactory ---");
        System.out.println("已有代码完全不需要改动，符合开闭原则。");
    }
}
