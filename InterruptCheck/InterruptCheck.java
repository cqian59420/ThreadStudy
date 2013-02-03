package Thread.ThreadStudy.InterruptCheck;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Terrance
 * Date: 13-2-3
 * Time: 下午11:53
 * To change this template use File | Settings | File Templates.
 */
public class InterruptCheck extends Thread {

    @Override
    public void run() {
        System.out.println("Thread start");
        while (true){
            if(Thread.currentThread().isInterrupted())
                break;
            System.out.println("while exit");
        }
    }

    public static void main(String[] args) {
        Thread thread =new  InterruptCheck();
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Main Thread ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }
}
