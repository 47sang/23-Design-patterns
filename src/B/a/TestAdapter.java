package B.a;

/**
 * 适配器
 *
 * @author 周士钰
 * @date 2024/6/19 下午11:16
 */
// 让我们的适配器继承TestSupplier并且实现Target接口
public class TestAdapter extends TestSupplier implements Target {

    // 接着实现supply方法，直接使用TestSupplier提供的实现
    @Override
    public String supply() {
        return super.doSupply();
    }
}
