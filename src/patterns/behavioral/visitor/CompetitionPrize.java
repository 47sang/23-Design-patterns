package patterns.behavioral.visitor;

/**
 * 比赛奖项（CompetitionPrize）— 访问者模式中的具体元素。
 *
 * <h2>设计意图</h2>
 * <p>代表一个具体的比赛奖项，包含比赛名称和奖金金额。
 * 当访问者访问此元素时，通过 {@link #accept(PrizeVisitor)} 方法
 * 将自身传递给访问者，让访问者根据自己的类型执行评价操作。</p>
 *
 * <h2>双分派中的角色</h2>
 * <p>在双分派机制中，CompetitionPrize 是"被分派"的一方。
 * 当调用 {@code accept(visitor)} 时：</p>
 * <ol>
 *   <li>第一次分派：Java 根据 PrizeElement 的实际类型
 *       （这里是 CompetitionPrize）选择 accept 方法</li>
 *   <li>第二次分派：在 accept 中调用 {@code visitor.visit(this)}，
 *       Java 根据 visitor 的实际类型和 CompetitionPrize 类型
 *       选择对应的 visit(CompetitionPrize) 方法</li>
 * </ol>
 *
 */
public class CompetitionPrize implements PrizeElement {

    /** 比赛名称 */
    private final String competitionName;
    /** 奖金金额（元） */
    private final double prizeMoney;

    /**
     * 构造一个比赛奖项。
     *
     * @param competitionName 比赛名称
     * @param prizeMoney      奖金金额
     */
    public CompetitionPrize(String competitionName, double prizeMoney) {
        this.competitionName = competitionName;
        this.prizeMoney = prizeMoney;
    }

    /**
     * 接受访问者 — 双分派的第一层。
     *
     * <p>将自身传递给访问者，触发访问者中
     * {@link PrizeVisitor#visit(CompetitionPrize)} 方法的调用。</p>
     *
     * @param visitor 要接受的访问者
     */
    @Override
    public void accept(PrizeVisitor visitor) {
        visitor.visit(this);
    }

    /** @return 比赛名称 */
    public String getCompetitionName() {
        return competitionName;
    }

    /** @return 奖金金额 */
    public double getPrizeMoney() {
        return prizeMoney;
    }

    /**
     * 返回奖项的摘要信息。
     */
    public String getSummary() {
        return competitionName + "（奖金 " + prizeMoney + " 元）";
    }

    @Override
    public String toString() {
        return getSummary();
    }
}
