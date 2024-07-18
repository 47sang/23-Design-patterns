package A.d;

/**
 * @author 周士钰
 * @date 2024/6/16 下午5:41
 */
public class Main {
    public static void main(String[] args) {
        SingletonLazy instance = SingletonLazy.getInstance();
        Singleton instance1 = Singleton.getInstance();


        System.out.println(instance);
        System.out.println(instance1);

        for (int i = 0; i < 10; i++) {
            TreadPrin t = new TreadPrin();
            new Thread(t).start();
        }
    }


    public static class TreadPrin implements Runnable{

        @Override
        public void run() {

            System.out.println("线程:"+Thread.currentThread().getName());
            SingletonLazy instance = SingletonLazy.getInstance();


            System.out.println(instance);

        }
    }
}
