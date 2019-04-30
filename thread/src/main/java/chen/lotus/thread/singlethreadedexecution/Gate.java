package chen.lotus.thread.singlethreadedexecution;

import lombok.extern.java.Log;

@Log
public class Gate {

    private int counter;

    private String name ="NoBody";

    private String address ="NoWhere";


    public synchronized void pass(String name, String address) {
        counter++;
        this.name = name;
        //TODO
        this.address = address;
        check();
    }

    //如果这方法是public的如何
    private void check() {
        //opps
        if (name.charAt(0) != address.charAt(0)) {
            log.info("broken " + toString());
        }
    }

}
