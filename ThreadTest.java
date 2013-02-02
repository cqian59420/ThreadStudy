package Thread.ThreadStudy;

import java.util.Random;

public class ThreadTest {

    public static void main(String[] args) {
        System.out.println("in " + Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        CounterThread[] ct = new CounterThread[3];
        for (int i = 0; i < ct.length; i++) {
            ct[i] = new CounterThread();
            ct[i].start();
            try {
                ct[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("join total time = " + (end - start));
        int result = 0;
        for (int j = 0; j < ct.length; j++) {
            result += ct[j].getResult();
        }
        System.out.println("the result is " + result);

    }

}

class CounterThread extends Thread {

    public CounterThread() {
    }

    private int result;

    public int getResult() {
        return result;
    }

    public void run() {
        try {
            int time = (new Random().nextInt() >>> 1) % 5000;
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName() + " is blocked for " + time + "ms");
        } catch (InterruptedException ex) {

        }
        result = 5;
    }
}