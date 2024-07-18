package A.c;

/**
 * @author 周士钰
 * @date 2024/6/16 下午5:17
 */
public class Main {

    public static void main(String[] args) {
        Student student = Student.builder()
                                        .id(1)
                                        .age(2)
                                        .grade(3)
                                        .name("姓名")
                                        .college("专业")
                                        .awards("打dota", "写代码")
                                        .build();

        System.out.println(student);

    }
}
