package ticket;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cq on 2017/2/14.
 */

/**
 * 缺点是不公平,待修改
 */
public class SaleTicket {

    public static void main(String[] args) {

        final AtomicInteger totalTickets
                = new AtomicInteger(500);


        Runnable runnable = new Runnable() {

            public void run() {
                if (totalTickets.get()>0) {
                    totalTickets.decrementAndGet();
                    System.out.println(Thread.currentThread().getName() + "购买一张票，还剩:" + totalTickets.get());
                }else {
                    System.out.println(Thread.currentThread().getName() + "没买到票");
                }
            }
        };


        for (int i = 0; i < 502; i++) {
            new Thread(runnable, String.valueOf(i)).start();
        }

    }

}
