package C.k;

/**
 * @author 周士钰
 * @date 2024/7/20 下午4:24
 */
public class Family implements Visitor{
    @Override
    public void visit(Prize prize) {
        System.out.println("孩子，辛苦了，有没有好好照顾自己啊");
        System.out.println("你得了什么奖啊？"+prize.name+"，很不错，要继续加油啊！");
    }
}
