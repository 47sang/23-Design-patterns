package patterns.behavioral.visitor;

/**
 * 老师视角访问者（TeacherVisitor）— 访问者模式中的具体访问者。
 *
 * <h2>视角特点</h2>
 * <p>老师关注的是比赛的专业性和奖项的等级，
 * 以及对学生能力提升的帮助，而不是奖金金额。</p>
 *
 */
public class TeacherVisitor implements PrizeVisitor {

    /** 访问者名称 */
    private final String name;

    /**
     * 构造一个老师视角访问者。
     *
     * @param name 老师姓名
     */
    public TeacherVisitor(String name) {
        this.name = name;
    }

    /**
     * 评价比赛奖项 — 从老师的教育视角出发。
     *
     * @param prize 要访问的比赛奖项
     */
    @Override
    public void visit(CompetitionPrize prize) {
        System.out.println("  📚 [" + name + "（老师视角）] 评价奖项 \"" + prize.getCompetitionName() + "\":");
        double money = prize.getPrizeMoney();
        System.out.println("     📝 比赛名称：" + prize.getCompetitionName());
        System.out.println("     💵 奖金金额：" + money + " 元");
        if (money >= 5000) {
            System.out.println("     ⭐ 级别较高，可以加综合素质分，记入档案。");
        } else if (money >= 1000) {
            System.out.println("     ✓  级别适中，有助于能力提升，继续努力。");
        } else {
            System.out.println("     📌 级别一般，重在参与，积累经验也很重要。");
        }
    }

    @Override
    public String toString() {
        return name + "（老师视角）";
    }
}
