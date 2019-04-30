package chen.lotus.thread.balking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IllegalTest {

    public static void main(String[] args) {
        Thread happyThread = new Thread(() -> {
            log.info("thread happy running");
        });

        while (true) {
            happyThread.start();
        }
    }
}
