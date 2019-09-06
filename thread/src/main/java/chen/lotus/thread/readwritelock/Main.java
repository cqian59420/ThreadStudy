package chen.lotus.thread.readwritelock;

public class Main {

    public static void main(String[] args) {
        Data data = new Data(10);

        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new WriteThread(data,"ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
        new WriteThread(data,"abcdefghijklmnopqrstuvwxyz").start();
    }
}
