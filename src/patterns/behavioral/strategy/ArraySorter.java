package patterns.behavioral.strategy;

/**
 * 数组排序器（ArraySorter）— 策略模式中的上下文对象。
 *
 * <h2>设计意图</h2>
 * <p>排序器持有排序策略的引用，将排序操作委托给策略对象。
 * 客户端可以通过 {@link #setStrategy(SortStrategy)} 动态切换排序策略，
 * 而排序器本身不需要修改任何代码。</p>
 *
 * <h2>核心机制</h2>
 * <p>当客户端调用 {@link #sort(int[])} 时，
 * 排序器将数组委托给当前持有的策略对象执行排序。
 * 通过组合不同的策略，同一个排序器可以使用不同的排序算法。</p>
 *
 * <h2>与策略模式的关系</h2>
 * <ul>
 *   <li>{@link SortStrategy} — 策略接口，定义排序算法的统一契约</li>
 *   <li>{@link QuickSortStrategy} / {@link MergeSortStrategy} /
 *       {@link BubbleSortStrategy} — 具体策略，各自实现不同的排序算法</li>
 *   <li>{@link ArraySorter} — 上下文，持有策略引用并委托执行</li>
 * </ul>
 *
 */
public class ArraySorter {

    /** 当前使用的排序策略 */
    private SortStrategy strategy;

    /**
     * 设置排序策略。
     *
     * <p>可以在运行时动态切换排序策略，
     * 例如根据数组大小选择不同的算法。</p>
     *
     * @param strategy 要使用的排序策略
     */
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 使用当前策略对数组进行排序。
     *
     * <p>委托给当前策略的 {@link SortStrategy#sort(int[])} 方法执行排序。</p>
     *
     * @param array 待排序的整数数组
     * @throws IllegalStateException 当未设置策略时抛出
     */
    public void sort(int[] array) {
        if (strategy == null) {
            throw new IllegalStateException("请先设置排序策略，调用 setStrategy() 方法。");
        }
        System.out.println("🔧 使用策略: " + strategy);
        strategy.sort(array);
        System.out.println("  排序结果: " + arrayToString(array));
    }

    /**
     * 将数组转换为字符串，方便打印。
     */
    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
