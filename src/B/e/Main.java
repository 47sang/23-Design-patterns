package B.e;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:20
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        subject.test();

        // 使用代理
        Proxy proxy = new Proxy(subject);
        proxy.test();
    }
}
