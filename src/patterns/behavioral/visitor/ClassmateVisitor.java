package patterns.behavioral.visitor;

/**
 * 同学视角访问者（ClassmateVisitor）— 访问者模式中的具体访问者。
 *
 * <h2>视角特点</h2>
 * <p>同学之间的评价通常比较"真实"，觉得比赛一般般，
 * 下次可能不太想去，但嘴上还是会说"恭喜恭喜"。</p>
 *
 */
public class ClassmateVisitor implements PrizeVisitor {

    /** 访问者名称 */
    private final String name;

    /**
     * 构造一个同学视角访问者。
     *
     * @param name 同学姓名
     */
    public ClassmateVisitor(String name) {
        this.name = name;
    }

    /**
     * 评价比赛奖项 — 从同学视角出发。
     *
     * @param prize 要访问的比赛奖项
     */
    @Override
    public void visit(CompetitionPrize prize) {
        System.out.println("  🎓 [" + name + "（同学视角）] 评价奖项 \"" + prize.getCompetitionName() + "\":");
        double money = prize.getPrizeMoney();
        if (money >= 3000) {
            System.out.println("     😮 哇！" + money + " 元奖金！可以啊，下次带带我！");
        } else if (money >= 500) {
            System.out.println("     🙂 恭喜恭喜！" + money + " 元，一般般吧，下次别去了。");
        } else {
            System.out.println("     😂 哈哈，才 " + money + " 元？下次这种比赛叫我就算了。");
        }
    }

    @Override
    public String toString() {
        return name + "（同学视角）";
    }
}
