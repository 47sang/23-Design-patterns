package C.k;

/**
 * @author 周士钰
 * @date 2024/7/20 下午4:24
 */
public class Boss implements Visitor{
    @Override
    public void visit(Prize prize) {
        System.out.println("你的奖项大么，能够为公司带来什么效益么？");
        System.out.println("还不如老老实实加班给我多干干，别去搞这些没用的");
    }
}
