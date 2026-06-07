package patterns.creational.factory.abstract_factory;

/**
 * 具体产品 — 苹果手机
 *
 * <p>苹果电子产品族中的手机产品。
 * 由 {@link AppleFactory} 创建，与同工厂创建的平板、耳机风格一致。</p>
 *
 */
public class ApplePhone implements Phone {

    private final String model;
    private final double price;

    /**
     * 构造一个苹果手机实例
     *
     * @param model 手机型号（如 "iPhone 17 Pro"）
     * @param price 售价（元）
     */
    public ApplePhone(String model, double price) {
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
        System.out.println("  📱 " + getBrand() + " " + model + " — ¥" + price);
    }
}
