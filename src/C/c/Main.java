package C.c;

/**
 * @author 周士钰
 * @date 2024/7/20 上午12:19
 */
public class Main {

    public static void main(String[] args) {

        Handler handler = new FirstHandler();

        handler.connect(new SecondHandler())
                .connect(new ThirdHandler());

        handler.handle();
    }
}
