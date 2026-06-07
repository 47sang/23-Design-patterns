package patterns.structural.adapter;

import java.math.BigDecimal;

/**
 * 适配器模式演示入口
 *
 * <p>演示类适配器和对象适配器两种实现方式，
 * 展示如何将第三方支付 SDK 的接口统一为系统内部的标准接口。</p>
 *
 * <h2>演示流程</h2>
 * <ol>
 *   <li>创建第三方支付 SDK 实例（被适配者）</li>
 *   <li>使用类适配器包装，通过目标接口调用</li>
 *   <li>使用对象适配器包装，通过目标接口调用</li>
 *   <li>对比两种适配器的优缺点</li>
 * </ol>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 适配器模式演示 ==========");
        System.out.println();

        // 被适配者：第三方支付 SDK
        PaymentSDK thirdPartySDK = new PaymentSDK();

        // ========== 类适配器演示 ==========
        System.out.println("--- 类适配器 ---");
        PaymentTarget classAdapter = new ClassAdapter();
        classAdapter.pay(new BigDecimal("99.99"));
        System.out.println();

        // ========== 对象适配器演示 ==========
        System.out.println("--- 对象适配器 ---");
        PaymentTarget objectAdapter = new ObjectAdapter(thirdPartySDK);
        objectAdapter.pay(new BigDecimal("199.50"));
        System.out.println();

        // ========== 对比总结 ==========
        System.out.println("========== 两种适配器对比 ==========");
        System.out.println("类适配器：通过继承 PaymentSDK + 实现 PaymentTarget");
        System.out.println("  - 优点：代码简洁，直接复用父类方法");
        System.out.println("  - 缺点：Java 单继承限制，无法同时适配多个 SDK");
        System.out.println();
        System.out.println("对象适配器：通过组合 PaymentSDK + 实现 PaymentTarget（推荐）");
        System.out.println("  - 优点：符合组合优于继承，可适配多个 SDK，灵活性高");
        System.out.println("  - 缺点：需要多写一层委托代码");
    }
}
