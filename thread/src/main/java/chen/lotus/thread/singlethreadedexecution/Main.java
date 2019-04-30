package chen.lotus.thread.singlethreadedexecution;

public class Main {

    public static void main(String[] args) {
        Gate gate = new Gate();

        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bill", "Button").start();
        new UserThread(gate, "Cici", "China").start();
    }


}
