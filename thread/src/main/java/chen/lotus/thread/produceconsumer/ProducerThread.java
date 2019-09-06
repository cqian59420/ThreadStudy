package chen.lotus.thread.produceconsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Exchanger;

@Slf4j
public class ProducerThread extends Thread {
    private final Exchanger<char[]> exchanger;

    private  char[] buffer=null;

    private char index=0;

    private final Random random;

    public ProducerThread(Exchanger<char[]> exchanger, char[] buffer1, int i) {
        super("producerThread");
        this.exchanger= exchanger;
        buffer = buffer1;
        this.random = new Random(i);
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = nextChar();
                    log.info("{} : {} ",currentThread().getName(),buffer[i]);
                }

                log.info("{} before exchange",currentThread().getName());
                exchanger.exchange(buffer);
                log.info("{} after exchange",currentThread().getName());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() throws InterruptedException {
        char c = (char) ('A' + index % 26);
        index++;
        sleep(random.nextInt(1000));
        return c;
    }
}
