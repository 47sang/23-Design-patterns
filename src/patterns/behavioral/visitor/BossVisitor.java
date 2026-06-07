package patterns.behavioral.visitor;

/**
 * 老板视角访问者（BossVisitor）— 访问者模式中的具体访问者。
 *
 * <h2>视角特点</h2>
 * <p>老板从商业价值角度看待奖项，只关心奖金金额。
 * 如果奖金不够高，认为不如加班工作划算。</p>
 *
 * <h2>评价逻辑</h2>
 * <ul>
 *   <li>奖金 ≥ 5000 元：值得参加，商业价值高</li>
 *   <li>奖金 1000-5000 元：一般般，不如好好工作</li>
 *   <li>奖金 &lt; 1000 元：浪费时间，不如加班</li>
 * </ul>
 *
 */
public class BossVisitor implements PrizeVisitor {

    /** 访问者名称 */
    private final String name;

    /**
     * 构造一个老板视角访问者。
     *
     * @param name 老板姓名
     */
    public BossVisitor(String name) {
        this.name = name;
    }

    /**
     * 评价比赛奖项 — 从老板的商业视角出发。
     *
     * @param prize 要访问的比赛奖项
     */
    @Override
    public void visit(CompetitionPrize prize) {
        System.out.println("  👔 [" + name + "（老板视角）] 评价奖项 \"" + prize.getCompetitionName() + "\":");
        double money = prize.getPrizeMoney();
        if (money >= 5000) {
            System.out.println("     💰 奖金 " + money + " 元，商业价值不错！值得投入时间。");
        } else if (money >= 1000) {
            System.out.println("     🤔 奖金 " + money + " 元，一般般。有这个时间不如多完成几个项目。");
        } else {
            System.out.println("     😤 奖金才 " + money + " 元？纯浪费时间！不如回来加班！");
        }
    }

    @Override
    public String toString() {
        return name + "（老板视角）";
    }
}
