package C.g;

/**
 * @author 周士钰
 * @date 2024/7/20 下午3:53
 */
public class Main {

    public static void main(String[] args) {
        Student student = new Student();

        student.work("学习");
        System.out.println(student);

        State saveState = student.save();

        student.work("打游戏");
        System.out.println(student);

        student.restore(saveState);
        System.out.println(student);
    }
}
