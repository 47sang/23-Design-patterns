package A.a1;

/**
 * @author 周士钰
 * @date 2024/6/16 下午3:47
 */
public abstract class Fruit {
    private final String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "@" + hashCode();
    }
}
