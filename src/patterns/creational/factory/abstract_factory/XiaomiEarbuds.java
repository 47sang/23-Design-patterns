package patterns.creational.factory.abstract_factory;

/**
 * 具体产品 — 小米无线耳机
 *
 * <p>小米电子产品族中的无线耳机产品。
 * 由 {@link XiaomiFactory} 创建。</p>
 *
 */
public class XiaomiEarbuds implements Earbuds {

    private final String model;
    private final double price;
    private final boolean noiseCancellation;

    /**
     * 构造一个小米无线耳机实例
     *
     * @param model              耳机型号
     * @param price              售价（元）
     * @param noiseCancellation  是否支持主动降噪
     */
    public XiaomiEarbuds(String model, double price, boolean noiseCancellation) {
        this.model = model;
        this.price = price;
        this.noiseCancellation = noiseCancellation;
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
