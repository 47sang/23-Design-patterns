package C.j;

import java.util.Arrays;

/**
 * 排序方案
 * @author 周士钰
 * @date 2024/7/20 下午4:33
 */
public interface Strategy {

    /**
     * 单线程排序方案
     */
    Strategy SINGLE = Arrays::sort;
    /**
     * 并行排序方案
     */
    Strategy PARALLEL = Arrays::parallelSort;


    void sort(int[] array);
}
