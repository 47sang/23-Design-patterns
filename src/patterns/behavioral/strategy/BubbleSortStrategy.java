package patterns.behavioral.strategy;

/**
 * 冒泡排序策略（BubbleSortStrategy）— 策略模式中的具体策略。
 *
 * <h2>设计意图</h2>
 * <p>手动实现冒泡排序算法，展示策略模式中不同算法的独立实现。
 * 冒泡排序是最基础的排序算法，适合教学演示，
 * 但实际应用中效率较低，仅适用于小数据量场景。</p>
 *
 * <h2>算法特点</h2>
 * <ul>
 *   <li>时间复杂度：O(n²)（最坏、最好、平均都一样）</li>
 *   <li>空间复杂度：O(1)（原地排序）</li>
 *   <li>稳定排序</li>
 * </ul>
 *
 */
public class BubbleSortStrategy implements SortStrategy {

    /** 策略名称 */
    private static final String NAME = "冒泡排序";

    /**
     * 使用冒泡排序算法对数组进行排序。
     *
     * <p>包含一个优化：如果某一轮没有发生任何交换，
     * 说明数组已经有序，提前结束排序。</p>
     *
     * @param array 待排序的整数数组
     */
    @Override
    public void sort(int[] array) {
        System.out.println("  [" + NAME + "] 开始排序，数组长度: " + array.length);
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // 优化：本轮无交换，说明已有序
            }
        }
        System.out.println("  [" + NAME + "] 排序完成。");
    }

    /** @return 策略名称 */
    @Override
    public String toString() {
        return NAME;
    }
}
