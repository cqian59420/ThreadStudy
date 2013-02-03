package Thread.ThreadStudy.InterruptCheck;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Terrance
 * Date: 13-2-4
 * Time: 上午12:01
 * To change this template use File | Settings | File Templates.
 */
public class InterruptWait extends Thread {
    public static Object lock = new Object();

    @Override
    public void run() {
        System.out.println("start");
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    public static void main(String[] args) {
        Thread thread=new InterruptWait();
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        thread.interrupt();
    }
}
