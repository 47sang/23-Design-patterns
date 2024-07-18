package A.d;

/**
 * 饿汉式
 * @author 周士钰
 * @date 2024/6/16 下午5:39
 */
public class Singleton {

    private static final Singleton INSTANCE =new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
