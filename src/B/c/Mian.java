package B.c;

/**
 * @author 周士钰
 * @date 2024/7/18 下午9:57
 */
public class Mian {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Directory outer = new Directory();
        Directory inner = new Directory();

        outer.addComponent(inner);
        outer.addComponent(new File());
        inner.addComponent(new File());
        inner.addComponent(new File());

        outer.changeName();

        File file = new File();
        file.addComponent(inner);

    }
}
