package jni;

/**
 * @author 周士钰
 * @date 2024/6/17 下午9:19
 */
public class Main {
    static {
        System.loadLibrary("rust_lib");
    }

    static native void init();

    static native void say();

    static native int add(int a, int b);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main.init();
        Main.say();
        System.out.println(Main.add(1, 5044));
    }


}
