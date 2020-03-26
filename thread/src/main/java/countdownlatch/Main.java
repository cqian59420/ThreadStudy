package countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    public static final int TASKS = 10;

    public static void main(String[] args) {
        log.info("BEGIN");

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CountDownLatch doneLatch = new CountDownLatch(TASKS);

        try {
            for (int t = 0; t < TASKS; t++) {
                executorService.execute(new MyTask(doneLatch,t));
            }

            log.info("AWAIT");
            //等待10个任务全部完成
            doneLatch.await();
        } catch (InterruptedException e) {

        } finally {
            executorService.shutdown();
            log.info("END");
        }
    }
}
