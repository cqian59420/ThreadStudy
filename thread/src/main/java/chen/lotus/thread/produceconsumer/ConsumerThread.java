package chen.lotus.thread.produceconsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Exchanger;

@Slf4j
public class ConsumerThread extends Thread{
    private final Exchanger<char[]> exchanger;
    private char[] buffer=null;
    private final Random random;

    public ConsumerThread(Exchanger<char[]> exchanger, char[] buffer2, int seed) {
        super("consumer thread");
        this.exchanger = exchanger;
        this.buffer = buffer2;
        random = new Random(seed);
    }


    @Override
    public void run() {
        try {
            while (true) {
                log.info("{} before exchange ",currentThread().getName());
                buffer = exchanger.exchange(buffer);
                log.info("{} after exchange ",currentThread().getName());

                for (int i = 0; i < buffer.length; i++) {
                    log.info("{} -> {}",currentThread().getName(),buffer[i]);
                    sleep(random.nextInt(1000));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
