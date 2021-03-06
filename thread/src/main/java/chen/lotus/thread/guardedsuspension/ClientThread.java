package chen.lotus.thread.guardedsuspension;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class ClientThread extends Thread {

    private final Random random;

    private final RequestQueue requestQueue;


    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i);
            log.info("{} 发送请求: {}", currentThread().getName(), request);
            requestQueue.addRequest(request);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
