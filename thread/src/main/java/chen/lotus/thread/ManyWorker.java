package chen.lotus.thread;

public class ManyWorker {

    public static void main(String[] args) {
        new Worker("tom").start();
        new Worker("jerry").start();

        System.out.println("work finsh");
    }
}
