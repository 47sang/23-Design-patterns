package B.e.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:29
 */
public class Main {

    public static void main(String[] args) {
        //被代理的大冤种
        SubjectImpl subject = new SubjectImpl();
        InvocationHandler testProxy = new TestProxy(subject);

        Subject proxy =(Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), testProxy);

        proxy.test();
    }
}
