package chen.lotus.thread.singlethreadedexecution;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EaterThread extends Thread {

    private String name;
    private final Tool leftHand;
    private final Tool rightHand;

    public EaterThread(String name, Tool leftHand, Tool rightHand) {
        this.name = name;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    @Override
    public void run() {
        while (true) {
            eat();
        }
    }

    private void eat() {
        synchronized (leftHand) {
            log.info("{} 拿起了 {},(left)", name, leftHand);
            synchronized (rightHand) {
                log.info("{} 拿起了 {},(right)", name, rightHand);
                log.info("{} 正在开怀大吃", name);
                log.info("{} 放下了 {}", name, rightHand);
            }
            log.info("{} 放下了 {}", name, leftHand);
        }
    }
}
