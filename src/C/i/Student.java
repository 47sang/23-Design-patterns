package C.i;

/**
 * 学生类
 * @author 周士钰
 * @date 2024/7/20 下午4:15
 */
public class Student {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void study() {
        switch (state) {
            case LAZY:
                System.out.println("学生懒散，不想学习");
                break;
            case NORMAL:
                System.out.println("学生正常学习");
                break;
            default:
                System.out.println("学生没有学习的状态,心不在焉");
                break;
        }
    }
}
