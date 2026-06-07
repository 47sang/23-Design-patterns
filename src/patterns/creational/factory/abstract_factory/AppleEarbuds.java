package patterns.creational.factory.abstract_factory;

/**
 * 具体产品 — 苹果无线耳机
 *
 * <p>苹果电子产品族中的无线耳机产品。
 * 由 {@link AppleFactory} 创建。</p>
 *
 */
public class AppleEarbuds implements Earbuds {

    private final String model;
    private final double price;
    private final boolean noiseCancellation;

    /**
     * 构造一个苹果无线耳机实例
     *
     * @param model              耳机型号
     * @param price              售价（元）
     * @param noiseCancellation  是否支持主动降噪
     */
    public AppleEarbuds(String model, double price, boolean noiseCancellation) {
        this.model = model;
        this.price = price;
        this.noiseCancellation = noiseCancellation;
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
    public boolean hasActiveNoiseCancellation() {
        return noiseCancellation;
    }

    @Override
    public void printInfo() {
        System.out.println("  🎧 " + getBrand() + " 耳机 " + model
                + " — ¥" + price
                + " | 降噪: " + (noiseCancellation ? "支持" : "不支持"));
    }
}
