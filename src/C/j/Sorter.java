package C.j;

/**
 * 排序类
 * @author 周士钰
 * @date 2024/7/20 下午4:32
 */
public class Sorter {

    /**
     * 策略
     */
    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void sort(int[] array){
        strategy.sort(array);
    }

}
