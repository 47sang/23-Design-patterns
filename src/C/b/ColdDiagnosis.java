package C.b;

/**
 * 感冒
 * @author 周士钰
 * @date 2024/7/18 下午10:51
 */
public class ColdDiagnosis extends AbstractDiagnosis{
    @Override
    public void prescribe() {
        System.out.println("3 >> 望闻问切后,你这是流行感冒");
    }

    @Override
    public void medicine() {
        System.out.println("4 >> 建议你服用板蓝根");
    }
}
