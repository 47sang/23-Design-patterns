package patterns.creational.factory.abstract_factory;

/**
 * 具体产品 — 小米手机
 *
 * <p>小米电子产品族中的手机产品。
 * 由 {@link XiaomiFactory} 创建，与同工厂创建的平板、耳机风格一致。</p>
 *
 */
public class XiaomiPhone implements Phone {

    private final String model;
    private final double price;

    /**
     * 构造一个小米手机实例
     *
     * @param model 手机型号（如 "Xiaomi 15 Pro"）
     * @param price 售价（元）
     */
    public XiaomiPhone(String model, double price) {
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
        System.out.println("  📱 " + getBrand() + " " + model + " — ¥" + price);
    }
}
