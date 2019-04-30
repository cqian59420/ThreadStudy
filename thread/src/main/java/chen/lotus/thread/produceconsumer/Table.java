package chen.lotus.thread.produceconsumer;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.currentThread;

@Slf4j
public class Table {
    private int count;
    private int tail;
    private int head;


    private final String[] buffer;

    public Table(int count) {
        buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }


    public synchronized void put(String cake) throws InterruptedException {
        log.info("{} 放 {}",currentThread().getName(),cake);

        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();

    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        log.info("{} 取 {}",currentThread().getName(),cake);
        return cake;
    }
}
