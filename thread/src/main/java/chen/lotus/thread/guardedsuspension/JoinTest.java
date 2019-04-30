package chen.lotus.thread.guardedsuspension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread joinThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                log.info("join thread is running:{}",i);
            }
        });

        joinThread.start();
        joinThread.join();
        log.info("main thread");

    }

}
