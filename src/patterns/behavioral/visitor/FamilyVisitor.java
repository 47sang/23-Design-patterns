package patterns.behavioral.visitor;

/**
 * 家人视角访问者（FamilyVisitor）— 访问者模式中的具体访问者。
 *
 * <h2>视角特点</h2>
 * <p>家人不关心奖金多少，只关心你辛不辛苦、有没有好好休息。
 * 无论获得什么奖项，都会鼓励你、关心你的身体。</p *
 *
 */
public class FamilyVisitor implements PrizeVisitor {

    /** 访问者名称 */
    private final String name;

    /**
     * 构造一个家人视角访问者。
     *
     * @param name 家人姓名（如"妈妈"、"爸爸"）
     */
    public FamilyVisitor(String name) {
        this.name = name;
    }

    /**
     * 评价比赛奖项 — 从家人的关心视角出发。
     *
     * @param prize 要访问的比赛奖项
     */
    @Override
    public void visit(CompetitionPrize prize) {
        System.out.println("  ❤️  [" + name + "（家人视角）] 评价奖项 \"" + prize.getCompetitionName() + "\":");
        double money = prize.getPrizeMoney();
        System.out.println("     🫂 宝贝你辛苦了！不管奖金多少，"
            + "你能获奖" + (money > 0 ? "还拿了 " + money + " 元奖金" : "")
            + "，我们都为你骄傲！");
        System.out.println("     🍚 最近太累了，回来给你做好吃的，好好休息！");
    }

    @Override
    public String toString() {
        return name + "（家人视角）";
    }
}
