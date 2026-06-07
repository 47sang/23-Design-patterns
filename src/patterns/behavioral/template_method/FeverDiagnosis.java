package patterns.behavioral.template_method;

/**
 * 发烧就诊流程（FeverDiagnosis）— 模板方法模式的具体子类。
 *
 * <h2>设计意图</h2>
 * <p>继承 {@link AbstractDiagnosis}，实现发烧这一具体病情对应的
 * "开处方"和"配药"步骤。通用步骤（挂号、检查）直接复用父类实现。</p>
 *
 * <h2>就诊流程</h2>
 * <pre>
 * 1. 挂号（通用）
 * 2. 检查：体温 39.2°C，血常规显示白细胞偏高
 * 3. 开处方：对乙酰氨基酚 + 头孢克肟
 * 4. 配药：取对乙酰氨基酚和头孢克肟各一盒
 * </pre>
 *
 */
public class FeverDiagnosis extends AbstractDiagnosis {

    /**
     * 开处方 — 针对发烧病情开具具体处方。
     *
     * <p>高烧（39.2°C）伴随白细胞偏高，提示可能存在细菌感染，
     * 处方包含对乙酰氨基酚（退烧）和头孢克肟（抗生素）。</p>
     */
    @Override
    protected void prescribe() {
        System.out.println("【发烧】开处方：对乙酰氨基酚片（一次1片，一日3次） + 头孢克肟分散片（一次1片，一日2次）");
    }

    /**
     * 配药 — 根据发烧处方配药。
     *
     * <p>在药房取对乙酰氨基酚2盒 + 头孢克肟1盒，并告知用法用量和注意事项。</p>
     */
    @Override
    protected void medicine() {
        System.out.println("【发烧】配药：已取药——对乙酰氨基酚片 2盒、头孢克肟分散片 1盒。体温超过38.5°C时服药，多喝水。");
    }
}
