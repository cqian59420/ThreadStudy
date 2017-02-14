package ticket;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cq on 2017/2/14.
 */
public class SaleTicket {

    public static void main(String[] args) {

        final AtomicInteger totalTickets
                = new AtomicInteger(500);


        Runnable runnable = new Runnable() {

            public void run() {
                totalTickets.decrementAndGet();
                System.out.println(Thread.currentThread().getName()+"购买一张票，还剩:"+totalTickets.get());
            }
        };


        for (int i = 0; i < 50; i++) {
            new Thread(runnable, String.valueOf(i)).start();
        }

    }

}
