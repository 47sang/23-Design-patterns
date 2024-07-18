package A.d;

/**
 * 完美的懒汉式
 *
 * 解决方案
 * 没有进行任何的加锁操作，也能保证线程安全
 * @author 周士钰
 * @date 2024/6/19 下午10:54
 */
public class SingletonHolder {

    private SingletonHolder() {}

    //由静态内部类持有单例对象，但是根据类加载特性，我们仅使用Singleton类时，不会对静态内部类进行初始化
    private static class Holder{
        private final static SingletonHolder INSTANCE = new SingletonHolder();
    }

    //只有真正使用内部类时，才会进行类初始化
    public static SingletonHolder getInstance(){
        //直接获取内部类中的
        return Holder.INSTANCE;
    }
}
