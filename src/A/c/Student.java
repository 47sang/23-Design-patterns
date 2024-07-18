package A.c;

import java.util.Arrays;
import java.util.List;

/**
 * @author 周士钰
 * @date 2024/6/16 下午5:16
 */
public class Student {
    int id;
    int age;
    int grade;
    String name;
    String college;
    String profession;
    List<String> awards;

    private Student(List<String> awards, String profession, String college, String name, int grade, int age, int id) {
        this.awards = awards;
        this.profession = profession;
        this.college = college;
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.id = id;
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        int id;
        int age;
        int grade;
        String name;
        String college;
        String profession;
        List<String> awards;

        public StudentBuilder id(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder grade(int grade) {
            this.grade = grade;
            return this;
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder college(String college) {
            this.college = college;
            return this;
        }

        public StudentBuilder profession(String profession) {
            this.profession = profession;
            return this;
        }

        public StudentBuilder awards(String... awards) {
            this.awards = Arrays.asList(awards);
            return this;
        }

        public Student build() {
            return new Student(awards, profession, college, name, grade, age, id);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", profession='" + profession + '\'' +
                ", awards=" + awards +
                "}@" +hashCode();
    }
}
