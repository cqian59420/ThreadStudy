package chen.lotus.thread.guardedsuspension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TalkThread extends Thread {

    private final RequestQueue input;
    private final RequestQueue output;


    public TalkThread(String name, RequestQueue input, RequestQueue output) {
        super(name);
        this.input = input;
        this.output = output;
    }


    @Override
    public void run() {
        log.info("{} begin:",currentThread().getName());
        for (int i = 0; i < 20; i++) {
            Request request = input.getRequest();
            log.info("{} 收到 {}",currentThread().getName(),request);

            Request request1 = new Request(request.getName() + "!");
            log.info("{} 返回 {}",currentThread().getName(),request1);
            output.addRequest(request1);
        }

        log.info("{} end:",currentThread().getName());
    }
}
