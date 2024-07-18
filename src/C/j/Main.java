package C.j;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 周士钰
 * @date 2024/7/20 下午4:20
 */
public class Main {

    public static void main(String[] args) {
        // thread1();

        // thread2();

        Sorter sorter = new Sorter();
        sorter.setStrategy(Strategy.PARALLEL);
        sorter.sort(new int[]{1, 102, 3, 14, 54, 6, 7, 84, 29, 10});
    }

    public static void thread1() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new SynchronousQueue<>(),// 这里不给排队
                new ThreadPoolExecutor.AbortPolicy());// 当线程池无法再继续创建新任务时，我们可以自由决定使用什么拒绝策略

        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        executor.execute(runnable);
        executor.execute(runnable);// 使用AbortPolicy，那么就是直接抛出异常
    }

    public static void thread2() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new SynchronousQueue<>(),
                new ThreadPoolExecutor.DiscardOldestPolicy());   // 使用DiscardOldestPolicy策略从队列中丢弃

        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        executor.execute(runnable);
        executor.execute(runnable);
    }
}
