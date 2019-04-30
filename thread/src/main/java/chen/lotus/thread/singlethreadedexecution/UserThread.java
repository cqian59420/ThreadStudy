package chen.lotus.thread.singlethreadedexecution;

import lombok.extern.java.Log;

@Log
public class UserThread extends Thread {

    private Gate gate;
    private String name;
    private String address;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        log.info(name + " start");
        while (true) {
            gate.pass(name, address);
        }
    }
}
