package C.k;

/**
 * 奖项
 *
 * @author 周士钰
 * @date 2024/7/20 下午4:22
 */
public class Prize {

    /**
     * 比赛名次
     */
    String name;
    /**
     * 等级
     */
    String level;

    public Prize(String name, String level) {

        this.name = name;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public String getLevel() {
        return this.level;
    }
}
