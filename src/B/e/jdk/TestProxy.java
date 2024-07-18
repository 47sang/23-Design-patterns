package B.e.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:28
 */
public class TestProxy implements InvocationHandler {

    private final Object target;

    public TestProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理的对象:"+proxy.getClass());
        Object result = method.invoke(target, args);
        System.out.println("方法调用完成,返回值:"+result);
        return result;
    }
}
