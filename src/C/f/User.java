package C.f;

/**
 * 用户类
 * @author 周士钰
 * @date 2024/7/20 下午3:40
 */
public class User {
    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户电话
     */
    private String tel;

    public User(String name,String tel){
        this.name = name;
        this.tel = tel;
    }

    /**
     * 根据地址查找该中介拥有的房东用户信息
     * @param address
     * @param mediator
     * @return
     */
    public User find(String address, Mediator mediator){
        return mediator.find(address);
    }

    @Override
    public String toString() {
        return name+"(电话:"+tel+")";
    }
}
