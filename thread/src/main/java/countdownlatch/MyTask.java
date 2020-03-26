package countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class MyTask implements Runnable {


    private final CountDownLatch doneLatch;
    private final int context;
    private static final Random random = new Random(314159);

    public MyTask(CountDownLatch doneLatch, int context) {
        this.doneLatch = doneLatch;
        this.context = context;
    }

    @Override
    public void run() {
        doTask();
        //完成一个latch减少一个
        doneLatch.countDown();
    }

    private void doTask() {
        //线程池里面的thread 的name包含了Thread的name
        String name = Thread.currentThread().getName();
        log.info(name + ":mytask:BEGIN:contecct=" + context);

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {

        } finally {
            log.info(name + ":mytask:END:contecct=" + context);

        }
    }
}
