package patterns.behavioral.memento;

/**
 * 学生备忘录（StudentMemento）— 备忘录模式中的备忘录对象。
 *
 * <h2>设计意图</h2>
 * <p>备忘录用于保存发起人（Student）在某个时刻的完整状态。
 * 备忘录本身是"数据容器"，不包含任何业务逻辑，
 * 只负责存储和提供状态数据。</p>
 *
 * <h2>封装策略</h2>
 * <p>为了在不破坏封装性的前提下保存状态，本实现采用以下策略：</p>
 * <ul>
 *   <li>字段使用 package-private 访问修饰符（无 public/private）</li>
 *   <li>Student 和 StudentMemento 在同一个包中，
 *       Student 可以直接访问备忘录的字段进行读写</li>
 *   <li>包外的类无法访问 StudentMemento 的字段，
 *       从而保护了内部状态不被外部篡改</li>
 * </ul>
 *
 * <p>这样，HomeworkCaretaker（负责人）只能持有 StudentMemento 的引用，
 * 但不能读取或修改其中的具体字段，只能委托 Student 来恢复状态。</p>
 *
 */
class StudentMemento {

    /** 作业内容 */
    String essay;
    /** 分数 */
    int score;

    /**
     * 构造一个学生备忘录。
     *
     * @param essay 作业内容
     * @param score 分数
     */
    StudentMemento(String essay, int score) {
        this.essay = essay;
        this.score = score;
    }
}
