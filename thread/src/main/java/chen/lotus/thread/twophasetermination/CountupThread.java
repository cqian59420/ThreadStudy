package chen.lotus.thread.twophasetermination;

import lombok.extern.java.Log;

@Log
public class CountupThread extends Thread {

    //计数位
    private long count = 0;

    //关闭标志位
    private volatile boolean shutdownRequested = false;


    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    public void shutdownRequest() {
        shutdownRequested = true;
        //interrupt方法，如果线程正在sleep或者wait，那么会抛出InterruptedException，如果不抛出异常，线程就变成中断状态
        //《图解Java多线程设计模式》 p239
        interrupt();
    }


    @Override
    public void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        } finally {
            doShutdown();
        }
    }

    private void doShutdown() {
        log.info("do work shutdown count:" + count);
    }

    private void doWork() throws InterruptedException {
        count++;
        log.info("do work count:" + count);
        Thread.sleep(500);
    }
}
