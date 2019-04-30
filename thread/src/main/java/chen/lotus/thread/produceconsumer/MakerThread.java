package chen.lotus.thread.produceconsumer;

import java.util.Random;

public class MakerThread extends Thread {

    private Table table;

    private Random random;

    private static int id = 0;

    public MakerThread(String cooker, Table table, int seed) {
        super(cooker);
        this.table = table;
        random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(random.nextInt(1000));
                String cake = "[Cake No. " + nextInt() + " By " + getName() + "]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized int nextInt() {
        return id++;
    }
}
