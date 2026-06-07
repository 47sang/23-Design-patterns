package patterns.behavioral.template_method;

/**
 * 模板方法模式演示 — 不同疾病的就诊流程。
 *
 * <h2>演示说明</h2>
 * <p>通过 {@link AbstractDiagnosis#diagnosis()} 模板方法，
 * 统一调用挂号 → 检查 → 开处方 → 配药的流程。
 * 不同子类（感冒、发烧）各自实现"开处方"和"配药"的差异化部分。</p>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 模板方法模式演示：不同疾病的就诊流程 ==========");
        System.out.println();

        // ---- 感冒就诊流程 ----
        System.out.println("===== 患者A：感冒就诊 =====");
        AbstractDiagnosis coldDiagnosis = new ColdDiagnosis();
        coldDiagnosis.diagnosis();
        System.out.println();

        // ---- 发烧就诊流程 ----
        System.out.println("===== 患者B：发烧就诊 =====");
        AbstractDiagnosis feverDiagnosis = new FeverDiagnosis();
        feverDiagnosis.diagnosis();
        System.out.println();

        System.out.println("========== 模板方法模式演示结束 ==========");
    }
}
