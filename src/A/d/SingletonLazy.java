package A.d;

/**
 * 懒汉式
 * @author 周士钰
 * @date 2024/6/16 下午5:39
 */
public class SingletonLazy {

    private static SingletonLazy INSTANCE;

    private SingletonLazy() {
    }

    public static synchronized SingletonLazy getInstance() {
        if (INSTANCE == null){
            INSTANCE = new SingletonLazy();
        }
        return INSTANCE;
    }
}
