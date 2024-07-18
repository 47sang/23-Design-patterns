package C.b;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:53
 */
public class Main {
    public static void main(String[] args) {
        AbstractDiagnosis diagnosis = new ColdDiagnosis();
        diagnosis.test();

        AbstractDiagnosis hotDiagnosis = new HotDiagnosis();
        hotDiagnosis.test();
    }
}
