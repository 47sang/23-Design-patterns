package B.e;

/**
 * 代理类
 * @author 周士钰
 * @date 2024/7/18 下午10:15
 */
public class Proxy extends Subject {

    // 代理模式中，代理类和被代理类通常需要实现相同的接口或继承相同的抽象类
    // 代理类中需要维护一个被代理类的对象，通过构造方法传入
    // 代理类中需要实现被代理类的方法，并在方法中调用被代理类的方法
    // 代理类中可以添加一些额外的操作，比如权限验证、日志记录等
    Subject target;

    public Proxy(Subject target) {
        this.target = target;
    }

    @Override
    public void test() {
        System.out.println("代理前执行业务");

        target.test();

        System.out.println("代理后执行业务");
    }
}
