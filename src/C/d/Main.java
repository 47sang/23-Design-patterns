package C.d;

/**
 * @author 周士钰
 * @date 2024/7/20 下午3:03
 */
public class Main {
    public static void main(String[] args) {

        Controller.call(new OpenCommand(new AirConditioner()));

        Controller.call(new OpenCommand(new FanConditioner()));

    }
}
