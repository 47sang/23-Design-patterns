package C.k;

/**
 * @author 周士钰
 * @date 2024/7/20 下午4:24
 */
public class Teacher implements Visitor{
    @Override
    public void visit(Prize prize) {
        System.out.println("你得奖是什么奖？"+prize.name);
        System.out.println("你得了几等奖？"+prize.level);
    }
}
