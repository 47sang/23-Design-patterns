package patterns.behavioral.strategy;

/**
 * 归并排序策略（MergeSortStrategy）— 策略模式中的具体策略。
 *
 * <h2>设计意图</h2>
 * <p>手动实现归并排序算法，展示策略模式中不同算法的独立实现。
 * 归并排序采用分治策略，将数组分成两半分别排序后再合并。</p>
 *
 * <h2>算法特点</h2>
 * <ul>
 *   <li>时间复杂度：O(n log n)（最坏、最好、平均都一样）</li>
 *   <li>空间复杂度：O(n)（需要额外的临时数组）</li>
 *   <li>稳定排序</li>
 * </ul>
 *
 */
public class MergeSortStrategy implements SortStrategy {

    /** 策略名称 */
    private static final String NAME = "归并排序";

    /**
     * 使用归并排序算法对数组进行排序。
     *
     * @param array 待排序的整数数组
     */
    @Override
    public void sort(int[] array) {
        System.out.println("  [" + NAME + "] 开始排序，数组长度: " + array.length);
        if (array.length > 1) {
            mergeSort(array, 0, array.length - 1);
        }
        System.out.println("  [" + NAME + "] 排序完成。");
    }

    /**
     * 归并排序的递归实现。
     *
     * @param array 待排序数组
     * @param left  左边界（包含）
     * @param right 右边界（包含）
     */
    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    /**
     * 合并两个有序子数组。
     *
     * @param array 原数组
     * @param left  左子数组起始索引
     * @param mid   左子数组结束索引
     * @param right 右子数组结束索引
     */
    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(array, left, leftArr, 0, n1);
        System.arraycopy(array, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }
        while (i < n1) {
            array[k++] = leftArr[i++];
        }
        while (j < n2) {
            array[k++] = rightArr[j++];
        }
    }

    /** @return 策略名称 */
    @Override
    public String toString() {
        return NAME;
    }
}
