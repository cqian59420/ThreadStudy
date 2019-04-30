package chen.lotus.thread.guardedsuspension;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class ServerThread extends Thread {

    private final Random random;

    private final RequestQueue requestQueue;


    public ServerThread(RequestQueue requestQueue,String name,long seed) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = requestQueue.getRequest();
            log.info("{} 处理请求:{}",currentThread().getName(),request);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
