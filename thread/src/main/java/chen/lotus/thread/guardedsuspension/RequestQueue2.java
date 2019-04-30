package chen.lotus.thread.guardedsuspension;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class RequestQueue2 {

    private final BlockingQueue<Request> requestQueue = new LinkedBlockingQueue<>();


    public Request getRequest() {
        Request request = null;
        try {
            //内含guarded Suspension
            request = requestQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return request;
    }

    public void addRequest(Request request) {
        try {
            requestQueue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
