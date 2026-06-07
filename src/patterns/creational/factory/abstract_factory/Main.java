package patterns.creational.factory.abstract_factory;

/**
 * 抽象工厂模式演示入口
 *
 * <h2>演示内容</h2>
 * <ol>
 *   <li>通过 {@link XiaomiFactory} 创建小米完整产品族</li>
 *   <li>通过 {@link AppleFactory} 创建苹果完整产品族</li>
 *   <li>强调"产品族"概念：同一工厂的产品风格/生态一致</li>
 *   <li>与工厂方法对比：工厂方法一个工厂只创建一种产品，抽象工厂一个工厂创建一族产品</li>
 * </ol>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===== 抽象工厂模式演示 =====");
        System.out.println();

        // 1. 小米产品族
        System.out.println("=== 小米产品族 ===");
        ElectronicsFactory xiaomiFactory = new XiaomiFactory();
        Phone xiaomiPhone = xiaomiFactory.createPhone();
        Tablet xiaomiTablet = xiaomiFactory.createTablet();
        Earbuds xiaomiEarbuds = xiaomiFactory.createEarbuds();
        xiaomiPhone.printInfo();
        xiaomiTablet.printInfo();
        xiaomiEarbuds.printInfo();
        System.out.println("  → 同一工厂创建，小米生态产品风格一致");
        System.out.println();

        // 2. 苹果产品族
        System.out.println("=== 苹果产品族 ===");
        ElectronicsFactory appleFactory = new AppleFactory();
        Phone applePhone = appleFactory.createPhone();
        Tablet appleTablet = appleFactory.createTablet();
        Earbuds appleEarbuds = appleFactory.createEarbuds();
        applePhone.printInfo();
        appleTablet.printInfo();
        appleEarbuds.printInfo();
        System.out.println("  → 同一工厂创建，苹果生态产品风格一致");
        System.out.println();

        // 3. 强调产品族概念
        System.out.println("=== 产品族概念 ===");
        System.out.println("同一个工厂（如 XiaomiFactory）创建的所有产品，");
        System.out.println("在品牌、设计语言、生态兼容性上保持一致性。");
        System.out.println("这就是抽象工厂模式的核心价值——保证产品族的协调性。");
    }
}
