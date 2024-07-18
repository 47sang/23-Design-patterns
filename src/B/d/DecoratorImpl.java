package B.d;

/**
 * 装饰实现
 * @author 周士钰
 * @date 2024/7/18 下午10:07
 */
public class DecoratorImpl extends Decorator{

    public DecoratorImpl(Base base) {
        super(base);
    }

    /**
     * 对原本的方法进行装饰，我们可以在前后都去添加额外操作
     */
    @Override
    public void test() {
        System.out.println("-------------------------");
        System.out.println("装饰方法,执行操作前的业务逻辑");
        super.test();
        System.out.println("装饰方法,执行操作后的业务逻辑");
        System.out.println("-------------------------");
    }
}
