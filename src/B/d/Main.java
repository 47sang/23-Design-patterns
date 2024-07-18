package B.d;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:09
 */
public class Main {

    public static void main(String[] args) {
        Base base = new BaseImpl();

        // 直接使用Base
        base.test();
        System.out.println("\n");
        // 将Base实现装饰一下
        Decorator decorator = new DecoratorImpl(base);
        decorator.test();
        System.out.println("\n");
        // 装饰者还可以嵌套
        Decorator outer = new DecoratorImpl(decorator);
        outer.test();
    }
}
