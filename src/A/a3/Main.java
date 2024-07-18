package A.a3;

import A.a1.Fruit;

import java.util.function.Supplier;

/**
 * @author 周士钰
 * @date 2024/6/16 下午5:08
 */
public class Main {
    public static void main(String[] args) {
        eat(new AppleFactory()::getFruit);
    }

    private static void eat(Supplier<Fruit> supplier) {
        System.out.println(supplier.get() + " 被吃掉了,真好吃.");
    }
}
