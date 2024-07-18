package A.a2;

import A.a1.Fruit;

/**
 * @author 周士钰
 * @date 2024/6/16 下午4:16
 */
public class Main {

    public static void main(String[] args) {
        Fruit fruit = FruitFactory.getFruit("橘子");
        System.out.println(fruit);
    }
}
