package patterns.behavioral.strategy;

import java.util.Arrays;

/**
 * 快速排序策略（QuickSortStrategy）— 策略模式中的具体策略。
 *
 * <h2>设计意图</h2>
 * <p>使用 Java 标准库的快速排序实现 {@link SortStrategy} 接口。
 * 快速排序的平均时间复杂度为 O(n log n)，是实际应用中最常用的排序算法之一。</p>
 *
 * <h2>算法特点</h2>
 * <ul>
 *   <li>平均时间复杂度：O(n log n)</li>
 *   <li>最坏时间复杂度：O(n²)（当数组已排序且选取首元素为 pivot 时）</li>
 *   <li>空间复杂度：O(log n)（递归栈）</li>
 *   <li>不稳定排序</li>
 * </ul>
 *
 */
public class QuickSortStrategy implements SortStrategy {

    /** 策略名称 */
    private static final String NAME = "快速排序";

    /**
     * 使用快速排序算法对数组进行排序。
     *
     * <p>委托给 Java 标准库的 {@link Arrays#sort(int[])} 方法，
     * 该方法在 JDK 中使用了双轴快速排序算法（Dual-Pivot Quicksort）。</p>
     *
     * @param array 待排序的整数数组
     */
    @Override
    public void sort(int[] array) {
        System.out.println("  [" + NAME + "] 开始排序，数组长度: " + array.length);
        Arrays.sort(array);
        System.out.println("  [" + NAME + "] 排序完成。");
    }

    /** @return 策略名称 */
    @Override
    public String toString() {
        return NAME;
    }
}
