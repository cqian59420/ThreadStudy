package chen.lotus.thread.produceconsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class InterrupteThread extends Thread{

    @Override
    public void run() {
        try {
            log.info("interrupt thread start");
            sleep(60443435343L);
            log.info("interrupt thread alive");
        } catch (InterruptedException e) {
            log.info("{} is interrupt by others:{}",currentThread().getName());
            e.printStackTrace();
        }
    }
}
