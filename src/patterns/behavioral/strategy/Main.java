package patterns.behavioral.strategy;

import java.util.Random;

/**
 * 策略模式演示 — 多种排序策略的切换。
 *
 * <h2>演示场景</h2>
 * <p>创建一个排序器，动态切换不同的排序策略，
 * 观察同一组数据在不同排序算法下的执行效果。</p>
 *
 * <h2>设计修复说明</h2>
 * <p>本实现修复了原代码中将策略实现直接写在接口中的问题。
 * SortStrategy 改为纯接口，每种排序算法作为独立的类实现该接口，
 * 符合单一职责原则和开闭原则。</p>
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========== 策略模式演示：多种排序策略 ==========");
        System.out.println();

        // ==================== 准备测试数据 ====================
        Random random = new Random(42); // 固定种子，保证结果可复现
        int[] data1 = generateRandomArray(random, 10);
        int[] data2 = generateRandomArray(random, 10);
        int[] data3 = generateRandomArray(random, 10);

        System.out.print("原始数据（复制三份用于对比）: ");
        printArray(data1);
        System.out.println();

        // ==================== 策略1：快速排序 ====================
        System.out.println("===== 策略1：快速排序 =====");
        ArraySorter sorter1 = new ArraySorter();
        sorter1.setStrategy(new QuickSortStrategy());
        sorter1.sort(cloneArray(data1));
        System.out.println();

        // ==================== 策略2：归并排序 ====================
        System.out.println("===== 策略2：归并排序 =====");
        ArraySorter sorter2 = new ArraySorter();
        sorter2.setStrategy(new MergeSortStrategy());
        sorter2.sort(cloneArray(data2));
        System.out.println();

        // ==================== 策略3：冒泡排序 ====================
        System.out.println("===== 策略3：冒泡排序 =====");
        ArraySorter sorter3 = new ArraySorter();
        sorter3.setStrategy(new BubbleSortStrategy());
        sorter3.sort(cloneArray(data3));
        System.out.println();

        // ==================== 动态切换策略 ====================
        System.out.println("===== 动态切换策略 =====");
        ArraySorter sorter = new ArraySorter();

        int[] dynamicData = generateRandomArray(random, 8);
        System.out.print("待排序数据: ");
        printArray(dynamicData);
        System.out.println();

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sort(cloneArray(dynamicData));

        sorter.setStrategy(new MergeSortStrategy());
        sorter.sort(cloneArray(dynamicData));

        sorter.setStrategy(new BubbleSortStrategy());
        sorter.sort(cloneArray(dynamicData));
        System.out.println();

        System.out.println("========== 策略模式演示结束 ==========");
    }

    /**
     * 生成随机整数数组。
     */
    private static int[] generateRandomArray(Random random, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100) + 1; // 1-100
        }
        return arr;
    }

    /**
     * 克隆数组，确保每次排序使用相同的原始数据。
     */
    private static int[] cloneArray(int[] source) {
        return java.util.Arrays.copyOf(source, source.length);
    }

    /**
     * 打印数组。
     */
    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.print("]");
    }
}
