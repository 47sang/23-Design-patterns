package patterns.behavioral.template_method;

/**
 * 感冒就诊流程（ColdDiagnosis）— 模板方法模式的具体子类。
 *
 * <h2>设计意图</h2>
 * <p>继承 {@link AbstractDiagnosis}，实现感冒这一具体病情对应的
 * "开处方"和"配药"步骤。通用步骤（挂号、检查）直接复用父类实现。</p>
 *
 * <h2>就诊流程</h2>
 * <pre>
 * 1. 挂号（通用）
 * 2. 检查：体温 37.8°C，流鼻涕，嗓子疼
 * 3. 开处方：感冒灵颗粒 + 布洛芬
 * 4. 配药：取感冒灵颗粒和布洛芬各一盒
 * </pre>
 *
 */
public class ColdDiagnosis extends AbstractDiagnosis {

    /**
     * 开处方 — 针对感冒病情开具具体处方。
     *
     * <p>感冒的典型症状是流鼻涕、嗓子疼、发烧，处方包含
     * 感冒灵颗粒（抗病毒）和布洛芬（退烧止痛）。</p>
     */
    @Override
    protected void prescribe() {
        System.out.println("【感冒】开处方：感冒灵颗粒（一次1袋，一日3次） + 布洛芬胶囊（一次1粒，必要时服用）");
    }

    /**
     * 配药 — 根据感冒处方配药。
     *
     * <p>在药房取感冒灵颗粒2盒 + 布洛芬1盒，并告知用法用量。</p>
     */
    @Override
    protected void medicine() {
        System.out.println("【感冒】配药：已取药——感冒灵颗粒 2盒、布洛芬胶囊 1盒。多喝水，注意休息。");
    }
}
