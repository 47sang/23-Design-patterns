package patterns.creational.factory.abstract_factory;

/**
 * 具体产品 — 小米平板
 *
 * <p>小米电子产品族中的平板产品。
 * 由 {@link XiaomiFactory} 创建。</p>
 *
 */
public class XiaomiTablet implements Tablet {

    private final String model;
    private final double price;

    /**
     * 构造一个小米平板实例
     *
     * @param model 平板型号（如 "Xiaomi Pad 7 Pro"）
     * @param price 售价（元）
     */
    public XiaomiTablet(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getBrand() {
        return "小米";
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
