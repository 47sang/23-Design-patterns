package B.a;

/**
 * 无继承的适配器
 * @author 周士钰
 * @date 2024/6/19 下午11:22
 */
public class TestAdapter2 implements Target {

    TestSupplier testSupplier;

    public TestAdapter2(TestSupplier testSupplier) {
        this.testSupplier = testSupplier;
    }

    @Override
    public String supply() {
        return testSupplier.doSupply();
    }
}
