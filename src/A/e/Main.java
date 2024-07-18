package A.e;

/**
 * @author 周士钰
 * @date 2024/6/19 下午11:00
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        int a = 10;
        int b = a;  // 基本类型浅拷贝
        System.out.println(a == b);

        Object o = new Object();
        Object k = o;    // 引用类型浅拷贝，拷贝的仅仅是对上面对象的引用
        System.out.println(o == k);


        Student student0 = new Student("张三");
        Student student1 = (Student) student0.clone();
        System.out.println(student0);
        System.out.println(student1);
        System.out.println(student0 == student1);
        System.out.println(student0.getName() == student1.getName());
    }
}
