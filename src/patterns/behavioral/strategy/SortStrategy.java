package patterns.behavioral.strategy;

/**
 * 排序策略接口（SortStrategy）— 策略模式中的策略角色。
 *
 * <h2>设计意图</h2>
 * <p>定义排序算法的统一接口。不同的排序策略（快速排序、归并排序、冒泡排序）
 * 都实现此接口，使它们可以相互替换。
 * 客户端（ArraySorter）持有 SortStrategy 的引用，可以动态切换排序策略。</p>
 *
 * <h2>函数式接口说明</h2>
 * <p>SortStrategy 是一个函数式接口（只包含一个抽象方法 {@link #sort(int[])}）。
 * 在现代 Java（8+）中，可以使用 Lambda 表达式简化策略模式的使用：</p>
 * <pre>
 * // 使用匿名类（传统写法）
 * sorter.setStrategy(new SortStrategy() {
 *     &#64;Override
 *     public void sort(int[] array) {
 *         Arrays.sort(array);
 *     }
 * });
 *
 * // 使用 Lambda 表达式（Java 8+）
 * sorter.setStrategy(array -> Arrays.sort(array));
 * </pre>
 * <p>但由于本项目的教学目的，我们仍然使用具体的策略类来展示模式的完整结构，
 * 这样更便于理解每种策略的独立实现。</p>
 *
 * <h2>具体策略类</h2>
 * <ul>
 *   <li>{@link QuickSortStrategy} — 快速排序</li>
 *   <li>{@link MergeSortStrategy} — 归并排序</li>
 *   <li>{@link BubbleSortStrategy} — 冒泡排序</li>
 * </ul>
 *
 */
public interface SortStrategy {

    /**
     * 对数组进行排序（原地排序）。
     *
     * <p>实现类应根据自己的算法对传入的数组进行排序，
     * 排序结果直接修改原数组。</p>
     *
     * @param array 待排序的整数数组
     */
    void sort(int[] array);
}
