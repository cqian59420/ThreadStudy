package chen.lotus.thread.twophasetermination;

import lombok.extern.java.Log;

@Log
public class Main {

    public static void main(String[] args) {

        log.info("two phase termination BEGIN:");
        try {
            CountupThread countupThread = new CountupThread();
            countupThread.start();

            Thread.sleep(10000);

            log.info("send shutdown request start");

            countupThread.shutdownRequest();

            //等待countupthread结束，main再继进行下去
            log.info("main join ");

            countupThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("main END");


    }

}
