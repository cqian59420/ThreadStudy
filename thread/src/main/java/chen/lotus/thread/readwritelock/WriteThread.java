package chen.lotus.thread.readwritelock;

import java.util.Random;

public class WriteThread extends Thread {

    private Data data;
    private String vars;

    private final static Random random = new Random();

    private int index = 0;

    public WriteThread(Data data, String vars) {
        this.data = data;
        this.vars = vars;
    }

    @Override
    public void run() {
        while (true) {
            char c = nextChar();
            data.write(c);
            sleep(random.nextInt(3000));
        }
    }
}
