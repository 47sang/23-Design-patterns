package patterns.behavioral.visitor;

/**
 * 奖品访问者接口（PrizeVisitor）— 访问者模式中的访问者角色。
 *
 * <h2>设计意图</h2>
 * <p>定义对不同类型奖品元素进行操作的接口。
 * 每个访问者实现此接口，为奖品提供自己视角的评价。</p>
 *
 * <h2>双分派机制说明</h2>
 * <p>访问者接口中的每个 {@code visit} 方法对应一种具体的元素类型。
 * 当元素调用 {@code visitor.visit(this)} 时，
 * Java 会根据元素的实际类型选择调用 visitor 的哪个 visit 重载方法。
 * 这就是双分派：先由元素类型决定调用哪个 accept，
 * 再由元素类型 + 访问者类型共同决定调用哪个 visit。</p>
 *
 * <h2>具体访问者</h2>
 * <ul>
 *   <li>{@link BossVisitor} — 老板视角，关注商业价值</li>
 *   <li>{@link FamilyVisitor} — 家人视角，关心你是否辛苦</li>
 *   <li>{@link ClassmateVisitor} — 同学视角，觉得一般般</li>
 *   <li>{@link TeacherVisitor} — 老师视角，关注奖项名称和等级</li>
 * </ul>
 *
 */
public interface PrizeVisitor {

    /**
     * 访问比赛奖项 — 为比赛奖项提供评价。
     *
     * <p>当访问者访问一个 {@link CompetitionPrize} 时，
     * 此方法被调用。访问者可以通过 prize 的 getter 方法
     * 获取奖项的详细信息（比赛名称、奖金等）。</p>
     *
     * @param prize 要访问的比赛奖项
     */
    void visit(CompetitionPrize prize);
}
