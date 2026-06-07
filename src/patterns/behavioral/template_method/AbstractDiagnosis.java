package patterns.behavioral.template_method;

/**
 * 抽象就诊流程（AbstractDiagnosis）— 模板方法模式的抽象类。
 *
 * <h2>模式说明</h2>
 * <p>定义了就诊流程的算法骨架（模板方法 {@link #diagnosis()}），
 * 将流程中不变的步骤（挂号、检查）实现为具体方法，
 * 将变化的步骤（开处方、配药）声明为抽象方法，
 * 由子类根据具体病情来提供不同的实现。</p>
 *
 * <h2>设计意图</h2>
 * <p>不同疾病的就诊流程在整体结构上是相同的（挂号 → 检查 → 开处方 → 配药），
 * 但"开处方"和"配药"的具体内容因病而异。
 * 模板方法模式将不变的部分提升到父类，变化的部分推迟到子类实现，
 * 既保证了流程的一致性，又保留了灵活性。</p>
 *
 * <h2>核心机制 — 模板方法</h2>
 * <p>{@link #diagnosis()} 被声明为 {@code final}，
 * 防止子类篡改流程顺序。它依次调用：
 * <pre>
 *   register() → examine() → prescribe() → medicine()
 * </pre>
 * 其中 register() 和 examine() 是具体方法（通用实现），
 * prescribe() 和 medicine() 是抽象方法（子类实现）。</p>
 *
 * <h2>子类</h2>
 * <ul>
 *   <li>{@link ColdDiagnosis} — 感冒就诊流程</li>
 *   <li>{@link FeverDiagnosis} — 发烧就诊流程</li>
 * </ul>
 *
 */
public abstract class AbstractDiagnosis {

    /**
     * 模板方法 — 定义就诊流程的算法骨架。
     *
     * <p>此方法被声明为 {@code final}，确保子类不能修改流程顺序。
     * 任何就诊流程都必须按照"挂号 → 检查 → 开处方 → 配药"的顺序执行。</p>
     */
    public final void diagnosis() {
        register();
        examine();
        prescribe();
        medicine();
    }

    /**
     * 挂号 — 具体方法。
     *
     * <p>所有疾病的就诊流程都需要挂号，此步骤的实现是通用的，
     * 因此在父类中直接实现，子类无需重写。</p>
     */
    protected void register() {
        System.out.println("【通用步骤】挂号：患者前往挂号处办理挂号手续，获取就诊号。");
    }

    /**
     * 检查 — 具体方法。
     *
     * <p>所有疾病的就诊流程都需要进行检查，此步骤的实现是通用的，
     * 因此在父类中直接实现，子类无需重写。</p>
     */
    protected void examine() {
        System.out.println("【通用步骤】检查：医生对患者进行常规检查，测量体温、血压等。");
    }

    /**
     * 开处方 — 抽象方法。
     *
     * <p>不同的疾病需要开不同的处方，此步骤的实现因病而异，
     * 因此声明为抽象方法，由子类根据具体病情来实现。</p>
     */
    protected abstract void prescribe();

    /**
     * 配药 — 抽象方法。
     *
     * <p>不同的处方对应不同的药品，配药步骤因病而异，
     * 因此声明为抽象方法，由子类根据处方来实现。</p>
     */
    protected abstract void medicine();
}
