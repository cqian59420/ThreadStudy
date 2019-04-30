package chen.lotus.thread.singlethreadedexecution;

import lombok.extern.java.Log;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Log
public class BoundeResource {

    private final Semaphore semaphore;

    private final int permits;

    private final static Random random = new Random(314159);


    public BoundeResource(int permits) {
        semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }

    private void doUse() throws InterruptedException {
        log.info(Thread.currentThread().getName() + " BEGIN  "+ (permits - semaphore.availablePermits()));
        TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
        log.info(Thread.currentThread().getName() + " USED  "+ (permits - semaphore.availablePermits()));
    }
}
