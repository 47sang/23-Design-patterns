package C.f;

import java.util.HashMap;
import java.util.Map;

/**
 * 房产中介
 *
 * @author 周士钰
 * @date 2024/7/20 下午3:18
 */
public class Mediator {
    // 在出售的房子需要存储一下
    private final Map<String, User> userMap = new HashMap<>();

    /**
     * 发布房屋出售信息
     *
     * @param address 地址
     * @param user    用户
     */
    public void register(String address, User user) {
        userMap.put(address, user);
    }

    /**
     * 根据地址查找房东信息
     *
     * @param address 地址
     * @return {@link User }
     */
    public User find(String address) {
        return userMap.get(address);
    }
}
