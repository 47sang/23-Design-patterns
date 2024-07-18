package B.g;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:43
 */
public class DBUtileFactory {

    private static final DBUtil UTIL = new DBUtil();

    public static DBUtil getFlyweight(){
        return UTIL;
    }
}
