package patterns.behavioral.memento;

/**
 * 备忘录模式演示 — 学生作业的保存和恢复。
 *
 * <h2>演示场景</h2>
 * <p>学生写作业的过程中，在不同阶段保存状态，
 * 然后修改作业内容，最后恢复到之前保存的状态。</p>
 *
 * <h2>角色说明</h2>
 * <ul>
 *   <li>{@link Student} — 发起人，拥有作业内容和分数</li>
 *   <li>{@link StudentMemento} — 备忘录，保存学生状态的不可变容器</li>
 *   <li>{@link HomeworkCaretaker} — 负责人，管理备忘录的存取</li>
 * </ul>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 备忘录模式演示：学生作业的保存和恢复 ==========");
        System.out.println();

        // ==================== 创建学生和备忘录管理员 ====================
        Student student = new Student(
            "这是我的第一篇作文，写了大约一百字的内容。",
            85
        );
        HomeworkCaretaker caretaker = new HomeworkCaretaker();

        // ==================== 显示初始状态 ====================
        System.out.println("===== 初始状态 =====");
        student.printStatus();
        System.out.println();

        // ==================== 写作业中途，保存状态 ====================
        System.out.println("===== 写作业中途，保存当前状态 =====");
        StudentMemento checkpoint1 = student.save();
        caretaker.save(checkpoint1);
        System.out.println();

        // ==================== 修改作业内容 ====================
        System.out.println("===== 继续写作业，修改内容 =====");
        student.setEssay("这是我的第一篇作文，写了大约一百字的内容。"
            + "后来我又补充了很多内容，现在有两百多字了。"
            + "我觉得这篇作文写得还不错，老师应该会给我高分。");
        student.setScore(70);
        student.printStatus();
        System.out.println();

        // ==================== 再保存一次 ====================
        System.out.println("===== 再次保存当前状态 =====");
        StudentMemento checkpoint2 = student.save();
        caretaker.save(checkpoint2);
        System.out.println();

        // ==================== 大幅修改作业 ====================
        System.out.println("===== 大幅修改作业 =====");
        student.setEssay("完全重写版：这是一篇关于春天的作文。"
            + "春天来了，万物复苏，大地一片生机勃勃的景象。"
            + "花儿开了，鸟儿叫了，小溪叮叮咚咚地流淌着。"
            + "我喜欢春天，因为它给人带来希望和温暖。"
            + "这篇作文我写了很多，希望能得到好成绩。");
        student.setScore(60);
        student.printStatus();
        System.out.println();

        // ==================== 恢复到第一次保存的状态 ====================
        System.out.println("===== 恢复到第一次保存的状态 =====");
        student.restore(checkpoint1);
        student.printStatus();
        System.out.println();

        // ==================== 恢复到第二次保存的状态 ====================
        System.out.println("===== 恢复到第二次保存的状态 =====");
        student.restore(checkpoint2);
        student.printStatus();
        System.out.println();

        System.out.println("========== 备忘录模式演示结束 ==========");
    }
}
