package chen.lotus.thread.singlethreadedexecution;

import java.util.Random;

public class ResourceHunter extends Thread {

    private final BoundeResource boundeResource;

    private final Random random = new Random(26535);

    public ResourceHunter(BoundeResource boundeResource) {
        this.boundeResource = boundeResource;
    }

    @Override
    public void run() {
        try {
            while (true) {
                boundeResource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
