package Thread.ThreadStudy;

import java.util.Deque;

/**
 * Created by IntelliJ IDEA.
 * User: Terrance
 * Date: 13-2-1
 * Time: 上午1:16
 * To change this template use File | Settings | File Templates.
 */
public class CleanerTask extends Thread{
    private Deque<Event> deque;
    public CleanerTask(Deque<Event> deque1){
        deque=deque;
        setDaemon(true);
    }
    @Override
    public void run() {
        super.run();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
