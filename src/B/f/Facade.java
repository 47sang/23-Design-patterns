package B.f;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:35
 */
public class Facade {

    SubSystemA a = new SubSystemA();

    SubSystemB b = new SubSystemB();

    SubSystemC c = new SubSystemC();

    public void marry() {
        a.doSomething();
        b.doSomething();
        c.doSomething();
    }


}
