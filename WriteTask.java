package Thread.ThreadStudy;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: Terrance
 * Date: 13-2-1
 * Time: 上午1:08
 * To change this template use File | Settings | File Templates.
 */
public class WriteTask implements Runnable{
    private Deque<Event> deque;

    public WriteTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            Event event=new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an  event",Thread.currentThread().getId()));
            deque.addFirst(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }
}
