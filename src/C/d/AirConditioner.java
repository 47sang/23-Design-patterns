package C.d;

/**
 * 空调-命令接收者
 * @author 周士钰
 * @date 2024/7/20 下午3:02
 */
public class AirConditioner implements Receiver{
    @Override
    public void action() {
        System.out.println("空调已开启,26°的凉风在吹");
    }
}
