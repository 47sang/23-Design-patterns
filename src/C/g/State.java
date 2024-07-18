package C.g;

/**
 * 状态
 *
 * @author 周士钰
 * @date 2024/7/20 下午3:50
 */
public class State {

    final String currentWork;

    final int percentage;

    State(String currentWork, int percentage){
        this.currentWork = currentWork;
        this.percentage = percentage;
    }
}
