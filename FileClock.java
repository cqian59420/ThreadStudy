package Thread.ThreadStudy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: Terrance
 * Date: 13-1-30
 * Time: 下午10:19
 * To change this template use File | Settings | File Templates.
 */
public class FileClock implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("被打断啦\n");
                e.printStackTrace();
            }
        }
    }
}

 class Main2 {
    public static void main(String[] asda) {
        FileClock fileClock = new FileClock();
        Thread task = new Thread(fileClock);
        task.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task.interrupt();
    }
}