package patterns.behavioral.memento;

/**
 * 学生（Student）— 备忘录模式中的发起人（Originator）。
 *
 * <h2>设计意图</h2>
 * <p>学生是状态的拥有者，负责创建备忘录保存当前状态，
 * 以及从备忘录恢复之前的状态。</p>
 *
 * <h2>核心方法</h2>
 * <ul>
 *   <li>{@link #save()} — 创建备忘录，保存当前作业内容和分数</li>
 *   <li>{@link #restore(StudentMemento)} — 从备忘录恢复状态</li>
 * </ul>
 *
 * <h2>备忘录的封装</h2>
 * <p>Student 和 StudentMemento 在同一个包中，
 * Student 可以直接访问 StudentMemento 的 package-private 字段。
 * 包外的类无法直接修改备忘录的内容，只能通过 Student 的 restore 方法来恢复状态。</p>
 *
 */
public class Student {

    /** 作业内容 */
    private String essay;
    /** 分数 */
    private int score;

    /**
     * 构造一个学生。
     *
     * @param essay 初始作业内容
     * @param score 初始分数
     */
    public Student(String essay, int score) {
        this.essay = essay;
        this.score = score;
    }

    /**
     * 创建备忘录 — 保存当前状态。
     *
     * <p>将当前的作业内容和分数封装到 StudentMemento 中返回。
     * 返回后，StudentMemento 的内容是不可变的（没有 setter）。</p>
     *
     * @return 包含当前状态的新备忘录
     */
    public StudentMemento save() {
        System.out.println("💾 保存当前状态：作业内容长度=" + essay.length()
            + "，分数=" + score);
        return new StudentMemento(essay, score);
    }

    /**
     * 恢复状态 — 从备忘录中恢复作业内容和分数。
     *
     * <p>将备忘录中的 essay 和 score 覆盖到当前对象的状态上。</p>
     *
     * @param memento 之前保存的备忘录
     */
    public void restore(StudentMemento memento) {
        this.essay = memento.essay;
        this.score = memento.score;
        System.out.println("🔄 状态已恢复：作业内容长度=" + essay.length()
            + "，分数=" + score);
    }

    /**
     * 修改作业内容。
     *
     * @param newEssay 新的作业内容
     */
    public void setEssay(String newEssay) {
        this.essay = newEssay;
    }

    /**
     * 设置分数。
     *
     * @param newScore 新的分数
     */
    public void setScore(int newScore) {
        this.score = newScore;
    }

    /**
     * 获取作业内容的前50个字符，方便展示。
     */
    public String getEssayPreview() {
        if (essay.length() <= 50) {
            return essay;
        }
        return essay.substring(0, 50) + "...";
    }

    /** @return 当前分数 */
    public int getScore() {
        return score;
    }

    /**
     * 打印学生当前状态。
     */
    public void printStatus() {
        System.out.println("  作业内容预览: " + getEssayPreview());
        System.out.println("  分数: " + score);
    }
}
