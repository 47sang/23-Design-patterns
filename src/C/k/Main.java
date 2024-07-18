package C.k;

/**
 * @author 周士钰
 * @date 2024/7/20 下午4:25
 */
public class Main {
    public static void main(String[] args) {
        Prize prize = new Prize("全国黑客比赛", "1000元奖金");

        Boss boss = new Boss();
        boss.visit(prize);

        Family family = new Family();
        family.visit(prize);
    }
}
