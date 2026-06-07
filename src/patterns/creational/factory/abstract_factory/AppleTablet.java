package patterns.creational.factory.abstract_factory;

/**
 * 具体产品 — 苹果平板
 *
 * <p>苹果电子产品族中的平板产品。
 * 由 {@link AppleFactory} 创建。</p>
 *
 */
public class AppleTablet implements Tablet {

    private final String model;
    private final double price;

    /**
     * 构造一个苹果平板实例
     *
     * @param model 平板型号（如 "iPad Pro M5"）
     * @param price 售价（元）
     */
    public AppleTablet(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getBrand() {
        return "Apple";
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void printInfo() {
        System.out.println("  📱 " + getBrand() + " 平板 " + model + " — ¥" + price);
    }
}
