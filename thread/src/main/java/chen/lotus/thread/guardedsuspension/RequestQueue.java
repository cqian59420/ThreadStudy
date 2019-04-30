package chen.lotus.thread.guardedsuspension;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class RequestQueue {

    private final Queue<Request> queue = new LinkedList<Request>();


    public synchronized Request getRequest() {
        //if
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public synchronized void addRequest(Request request) {
        queue.offer(request);
        //！i
        notifyAll();
    }
}
