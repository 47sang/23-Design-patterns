package B.d;

/**
 * 装饰者
 * @author 周士钰
 * @date 2024/7/18 下午10:05
 */
public class Decorator extends Base{

    // 装饰者需要将装饰目标组合到类中

    protected Base base;

    public Decorator(Base base) {
        this.base = base;
    }

    @Override
    public void test() {
        //这里暂时还是使用目标的原本方法实现
        base.test();
    }
}
