package C.i;

/**
 * @author 周士钰
 * @date 2024/7/20 下午4:17
 */
public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        // student.study();

        student.setState(State.NORMAL);
        student.study();


        student.setState(State.LAZY);
        student.study();
    }
}
