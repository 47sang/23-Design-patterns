package C.d;

/**
 * 开启空调的命令
 * @author 周士钰
 * @date 2024/7/20 下午3:02
 */
public class OpenCommand extends Command{

    public OpenCommand(AirConditioner airConditioner) {
        super(airConditioner);
    }

    public OpenCommand(FanConditioner fanConditioner) {
        super(fanConditioner);
    }
}
