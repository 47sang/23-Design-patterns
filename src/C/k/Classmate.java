package C.k;

/**
 * @author 周士钰
 * @date 2024/7/20 下午4:24
 */
public class Classmate implements Visitor{
    @Override
    public void visit(Prize prize) {
        System.out.println("你得了"+prize.name+"奖啊，还可以");
        System.out.println("不过这个奖没什么含金量，下次别去了");
    }
}
