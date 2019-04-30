package chen.lotus.thread.produceconsumer;

import java.util.Random;

public class EaterThread  extends Thread{

    private final Table table;

    private Random random;


    public EaterThread(String name, Table table, int seed) {
        super(name);
        this.table = table;
        random = new Random(seed);
    }


    @Override
    public void run() {
        try {
            while (true) {
                String cake = table.take();
                sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
