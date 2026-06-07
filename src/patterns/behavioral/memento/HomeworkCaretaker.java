package patterns.behavioral.memento;

/**
 * 作业备忘录管理员（HomeworkCaretaker）— 备忘录模式中的负责人。
 *
 * <h2>设计意图</h2>
 * <p>负责人负责管理备忘录对象，知道何时需要保存和恢复发起人的状态，
 * 但不了解备忘录内部的具体内容。
 * 负责人只持有 StudentMemento 的引用，不读取其中的 essay 和 score 字段。</p>
 *
 * <h2>职责边界</h2>
 * <ul>
 *   <li>可以保存备忘录（{@link #save(StudentMemento)}）</li>
 *   <li>可以提供备忘录（{@link #getMemento()}）</li>
 *   <li>不能读取备忘录内部的 essay 和 score（因为字段是 package-private 的）</li>
 *   <li>不能修改备忘录的内容（StudentMemento 没有 setter）</li>
 * </ul>
 *
 * <h2>与 Student 的关系</h2>
 * <p>Caretaker 持有 StudentMemento 的引用，
 * 当需要恢复状态时，将备忘录交给 Student 来处理。
 * Student 自行读取备忘录中的字段值来恢复自己的状态。</p>
 *
 */
public class HomeworkCaretaker {

    /** 当前保存的备忘录，null 表示尚未保存 */
    private StudentMemento memento;

    /**
     * 保存一个备忘录。
     *
     * <p>当学生写完作业、或完成一个重要里程碑时，
     * 调用此方法保存当前状态，以便后续可以恢复。</p>
     *
     * @param memento 要保存的学生备忘录
     */
    public void save(StudentMemento memento) {
        this.memento = memento;
    }

    /**
     * 获取之前保存的备忘录。
     *
     * <p>当学生需要恢复到之前的状态时，
     * 通过此方法获取备忘录，然后交给 Student 来恢复。</p>
     *
     * @return 之前保存的学生备忘录，如果从未保存则返回 null
     */
    public StudentMemento getMemento() {
        return memento;
    }
}
