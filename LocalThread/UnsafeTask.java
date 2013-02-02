package Thread.ThreadStudy.LocalThread;

import java.util.Date;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Terrance
 * Date: 13-2-3
 * Time: 上午1:01
 * To change this template use File | Settings | File Templates.
 */

//IDEA技巧，选择方法的时候，按ctrl+Q可以查看方法的doc
public class UnsafeTask implements Runnable{
private Date startDate;
    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((int)(Math.rint(Math.random() * 10)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate);

    }
}
