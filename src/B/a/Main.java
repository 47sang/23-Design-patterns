package B.a;

/**
 * @author 周士钰
 * @date 2024/6/19 下午11:14
 */
public class Main {

    public static void main(String[] args) {

        // 实现适配器
        TestAdapter testAdapter = new TestAdapter();
        // 使用适配器完成操作
        test(testAdapter);


        TestSupplier testSupplier = new TestSupplier();
        TestAdapter2 testAdapter2 = new TestAdapter2(testSupplier);
        test(testAdapter2);
    }

    // 原方法不能使用
    public static void test(Target target) {
        System.out.println("test:" + target.supply());
    }
}
