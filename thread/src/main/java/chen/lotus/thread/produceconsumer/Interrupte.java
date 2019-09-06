package chen.lotus.thread.produceconsumer;

public class Interrupte {


    public static void main(String[] args) {
        InterrupteThread interrupteThread = new InterrupteThread();
        interrupteThread.start();


        interrupteThread.interrupt();

    }
}
