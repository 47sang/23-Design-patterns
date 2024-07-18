package C.d;

/**
 * 遥控器
 * @author 周士钰
 * @date 2024/7/20 下午3:00
 */
public class Controller {

    public static void call(Command command){
        command.execute();
    }
}
