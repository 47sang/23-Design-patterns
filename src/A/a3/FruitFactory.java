package A.a3;

import A.a1.Fruit;

/**
 * @author 周士钰
 * @date 2024/6/16 下午5:04
 */
public abstract class FruitFactory<T extends Fruit> {
    public abstract T getFruit();
}
