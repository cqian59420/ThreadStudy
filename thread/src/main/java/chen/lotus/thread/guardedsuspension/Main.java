package chen.lotus.thread.guardedsuspension;

public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();

        new ClientThread(requestQueue,"阿强",3141592L).start();
        new ServerThread(requestQueue,"阿飞",6535873L).start();
    }
}
