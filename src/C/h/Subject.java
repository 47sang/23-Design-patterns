package C.h;

import java.util.HashSet;
import java.util.Set;

/**
 * 被观察者
 * @author 周士钰
 * @date 2024/7/20 下午3:58
 */
public class Subject {

    private final Set<Observer> observerSet = new HashSet<>();

    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    public void observer(Observer observer) {
        observerSet.add(observer);
    }

    /**
     * 模拟对象进行修改
     */
    public void modify(){
        //当对象发生修改时,通知所有的观察者,并进行方法回调
        observerSet.forEach(Observer::update);
    }
}
