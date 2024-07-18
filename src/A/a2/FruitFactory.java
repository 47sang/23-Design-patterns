package A.a2;

import A.a1.Apple;
import A.a1.Fruit;
import A.a1.Orange;

/**
 * @author 周士钰
 * @date 2024/6/16 下午4:15
 */
public class FruitFactory {


    public static Fruit getFruit(String type) {
        switch (type){
            case "苹果":
                return new Apple();
            case "橘子":
                return new Orange();
            default:
                return null;
        }
    }
}
