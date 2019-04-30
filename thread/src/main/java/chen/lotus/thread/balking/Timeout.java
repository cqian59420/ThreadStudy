package chen.lotus.thread.balking;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeoutException;

@Slf4j
public class Timeout {

    private final long timeout;

    private boolean ready = false;

    public Timeout(long timeout) {
        this.timeout = timeout;
    }

    public synchronized void setExecutable(boolean on) {
        ready = on;
        notifyAll();
    }


    public synchronized void execute() throws TimeoutException, InterruptedException {
        long start = System.currentTimeMillis();

        while (!ready) {
            long now = System.currentTimeMillis();
            long rest = timeout - (now - start);

            if (rest <= 0) {
                throw new TimeoutException("now-start:" + rest + " timeout:" + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    private void doExecute() {
        log.info("{} call doExecute", Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        Timeout timeout = new Timeout(10000);

        log.info("timeout tst begin:");

        try {
            timeout.execute();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
