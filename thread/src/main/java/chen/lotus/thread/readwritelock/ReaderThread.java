package chen.lotus.thread.readwritelock;

public class ReaderThread extends Thread {
    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }


    @Override
    public void run() {

    }
}
