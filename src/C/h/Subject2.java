package C.h;

import java.util.Date;
import java.util.Observable;

/**
 * @author 周士钰
 * @date 2024/7/20 下午4:10
 */
public class Subject2 extends Observable {

    /**
     * 修改
     */
    public void modify(){
        System.out.println("对对象进行修改!");
        //当对对象修改后，需要setChanged来设定为已修改状态
        this.setChanged();

        //使用notifyObservers方法来通知所有的观察者
        //注意只有已修改状态下通知观察者才会有效，并且可以给观察者传递参数，这里传递了一个时间对象
        this.notifyObservers(new Date());
    }
}
