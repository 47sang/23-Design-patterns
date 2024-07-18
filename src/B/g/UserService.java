package B.g;

/**
 * @author 周士钰
 * @date 2024/7/18 下午10:44
 */
public class UserService {

    public void service(){
        DBUtil util = DBUtileFactory.getFlyweight();
        util.selectDB();
    }
}
