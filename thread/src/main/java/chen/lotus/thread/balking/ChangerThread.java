package chen.lotus.thread.balking;

import java.util.Random;

public class ChangerThread extends Thread {

    private final OData data;

    private final Random random = new Random();

    public ChangerThread(String name, OData data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No: " + i);
//                sleep(random.nextInt(1000));
                data.save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
