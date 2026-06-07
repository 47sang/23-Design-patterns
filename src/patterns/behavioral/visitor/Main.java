package patterns.behavioral.visitor;

/**
 * 访问者模式演示 — 同一奖项在不同访问者眼中的不同评价。
 *
 * <h2>演示场景</h2>
 * <p>创建一个比赛奖项，用四种不同的访问者来评价它：
 * 老板（关注商业价值）、家人（关心你是否辛苦）、
 * 同学（觉得一般般）、老师（关注学术价值）。
 * 同一个奖项在不同人眼中有着完全不同的解读。</p>
 *
 * <h2>双分派机制演示</h2>
 * <p>整个调用过程体现了双分派：</p>
 * <pre>
 * prize.accept(bossVisitor)
 *   → 第一次分派：根据 prize 的类型（CompetitionPrize）选择 accept 方法
 *   → 第二次分派：在 accept 中调用 visitor.visit(this)，
 *      Java 根据 bossVisitor 的实际类型选择 visit(CompetitionPrize) 方法
 * </pre>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 访问者模式演示：奖品的多人评价系统 ==========");
        System.out.println();

        // ==================== 创建一个比赛奖项 ====================
        CompetitionPrize prize = new CompetitionPrize("全国大学生程序设计竞赛", 3000);
        System.out.println("🏆 奖项信息: " + prize.getSummary());
        System.out.println();

        // ==================== 四位访问者分别评价 ====================
        System.out.println("===== 老板评价 =====");
        PrizeVisitor boss = new BossVisitor("张总");
        prize.accept(boss);
        System.out.println();

        System.out.println("===== 家人评价 =====");
        PrizeVisitor mom = new FamilyVisitor("妈妈");
        prize.accept(mom);
        System.out.println();

        System.out.println("===== 同学评价 =====");
        PrizeVisitor classmate = new ClassmateVisitor("小李");
        prize.accept(classmate);
        System.out.println();

        System.out.println("===== 老师评价 =====");
        PrizeVisitor teacher = new TeacherVisitor("王教授");
        prize.accept(teacher);
        System.out.println();

        // ==================== 同一奖项，不同奖金，评价不同 ====================
        System.out.println("===== 换一个高奖金奖项 =====");
        CompetitionPrize bigPrize = new CompetitionPrize("ACM国际大学生程序设计竞赛", 8000);
        System.out.println("🏆 奖项信息: " + bigPrize.getSummary());
        System.out.println();

        bigPrize.accept(boss);
        System.out.println();
        bigPrize.accept(mom);
        System.out.println();
        bigPrize.accept(classmate);
        System.out.println();
        bigPrize.accept(teacher);
        System.out.println();

        System.out.println("========== 访问者模式演示结束 ==========");
    }
}
