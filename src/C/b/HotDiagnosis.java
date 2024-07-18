package C.b;

/**
 * 炎症
 * @author 周士钰
 * @date 2024/7/18 下午10:53
 */
public class HotDiagnosis extends AbstractDiagnosis{
    @Override
    public void prescribe() {
        System.out.println("3 >> 你这有炎症啊,还好不是很严重");
    }

    @Override
    public void medicine() {
        System.out.println("4 >> 你这得吃消炎药,我给你开点消炎药");
    }
}
