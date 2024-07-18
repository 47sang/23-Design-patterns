package C.d;

/**
 *  风扇-命令接收者
 * @author 周士钰
 * @date 2024/7/20 下午3:08
 */
public class FanConditioner implements Receiver{
    @Override
    public void action() {
        System.out.println("风扇打开飓风档位,开始使劲的吹");
    }
}
