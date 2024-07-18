package A.e;

/**
 * @author 周士钰
 * @date 2024/6/19 下午11:01
 */
public class Student implements Cloneable {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.name = new String(this.name);
        return student;
    }

}
