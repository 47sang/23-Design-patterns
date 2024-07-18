package C.g;

import java.util.Random;

/**
 * 学生类
 * @author 周士钰
 * @date 2024/7/20 下午3:48
 */
public class Student {

    /**
     * 当前正在做的事情
     */
    private String currentWork;

    /**
     * 当前工作进度百分比
     */
    private int percentage;

    public void work(String currentWork){
        this.currentWork = currentWork;
        this.percentage = new Random().nextInt(100);
    }

    @Override
    public String toString() {
        return "我正在做的是:" + currentWork + "(进度:" + percentage + "%))";
    }

    /**
     * 保存当前状态
     *
     * @return {@link State }
     */
    public State save(){
        return new State(currentWork,percentage);
    }

    /**
     * 恢复暂存的工作状态
     *
     * @param state 状态
     */
    public void restore(State state){

        this.currentWork = state.currentWork;
        this.percentage = state.percentage;
    }


}
