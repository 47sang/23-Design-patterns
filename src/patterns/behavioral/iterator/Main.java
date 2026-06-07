package patterns.behavioral.iterator;

/**
 * 迭代器模式演示 — 自定义数组集合的 for-each 遍历。
 *
 * <h2>演示说明</h2>
 * <p>{@link ArrayCollection} 实现了 {@link Iterable} 接口，
 * 因此可以直接使用 for-each 循环遍历。
 * 同时，也可以显式获取 {@link java.util.Iterator} 进行遍历。</p>
 *
 * <h2>核心知识点</h2>
 * <ul>
 *   <li>{@code Iterable<T>} 是"可被迭代的"标记接口，
 *       声明了 {@link Iterable#iterator()} 工厂方法</li>
 *   <li>{@code Iterator<T>} 是"迭代器"接口，
 *       提供了 {@code hasNext()}、{@code next()}、{@code remove()} 三个方法</li>
 *   <li>for-each 循环的底层就是通过调用 {@code iterator()} 获取迭代器，
 *       然后循环调用 {@code hasNext()} 和 {@code next()}</li>
 * </ul>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 迭代器模式演示：自定义数组集合遍历 ==========");
        System.out.println();

        // ==================== 创建集合并添加元素 ====================
        ArrayCollection<String> collection = new ArrayCollection<>();
        collection.add("苹果");
        collection.add("香蕉");
        collection.add("橙子");
        collection.add("葡萄");
        collection.add("西瓜");

        System.out.println("集合元素个数: " + collection.size());
        System.out.println();

        // ==================== 方式1：for-each 遍历 ====================
        System.out.println("--- 方式1：for-each 循环遍历 ---");
        for (String fruit : collection) {
            System.out.println("  遍历到元素: " + fruit);
        }
        System.out.println();

        // ==================== 方式2：显式使用 Iterator ====================
        System.out.println("--- 方式2：显式使用 Iterator 遍历 ---");
        java.util.Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            String fruit = it.next();
            System.out.println("  遍历到元素: " + fruit);
        }
        System.out.println();

        // ==================== 方式3：存储 Integer 类型的集合 ====================
        System.out.println("--- 方式3：存储 Integer 类型的集合 ---");
        ArrayCollection<Integer> numbers = new ArrayCollection<>();
        for (int i = 1; i <= 5; i++) {
            numbers.add(i * 10);
        }
        System.out.print("数字集合: ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();

        // ==================== 方式4：扩容测试 ====================
        System.out.println("--- 方式4：扩容测试（超过初始容量）---");
        ArrayCollection<String> bigCollection = new ArrayCollection<>(3);
        System.out.println("初始容量: 3");
        for (int i = 1; i <= 8; i++) {
            bigCollection.add("元素" + i);
        }
        System.out.println("添加8个元素后，集合大小: " + bigCollection.size());
        System.out.print("遍历结果: ");
        for (String elem : bigCollection) {
            System.out.print(elem + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("========== 迭代器模式演示结束 ==========");
    }
}
