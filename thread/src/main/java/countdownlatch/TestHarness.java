package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by cq on 2017/1/23.
 *
 * 线程都到达了开始计时，线程都执行完了记录结束时间
 */
public class TestHarness {

    public long timeTasks(int nThread, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThread);

        for (int i = 0; i < nThread; i++) {
            Thread t = new Thread() {
                public void run(){
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        long spendTime = end - start;
        System.out.println(spendTime);

        return spendTime;
    }
}
