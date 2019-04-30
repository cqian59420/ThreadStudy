package chen.lotus.thread.guardedsuspension;

public class TalkThreadMain {


    public static void main(String[] args) {
        RequestQueue requestQueue1 = new RequestQueue();
        RequestQueue requestQueue2 = new RequestQueue();
        //requestQueue1.addRequest(new Request("hello"));

        new TalkThread("阿强", requestQueue1, requestQueue2).start();
        new TalkThread("阿飞", requestQueue2, requestQueue1).start();
    }
}
