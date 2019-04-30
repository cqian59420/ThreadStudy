package chen.lotus.thread;

public class Worker extends Thread{
    private String message;

    public Worker(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println("worker working hard "+i +"=" +message);
        }
    }
}
