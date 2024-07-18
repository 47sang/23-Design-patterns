package A.a3;

import A.a1.Apple;

/**
 * @author 周士钰
 * @date 2024/6/16 下午5:04
 */
public class AppleFactory extends FruitFactory<Apple>{

    @Override
    public Apple getFruit() {
        return new Apple();
    }
}
