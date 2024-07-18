package C.h;

/**
 * @author 周士钰
 * @date 2024/7/20 下午4:00
 */
public class Main {

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.observer(() -> System.out.println("观察者1收到通知"));
        subject.observer(() -> System.out.println("观察者2收到通知"));

        subject.modify();


        Subject2 subject2 = new Subject2();
        subject2.addObserver((o, arg) -> System.out.println("观察者3收到通知" + arg));

        subject2.modify();
    }
}
