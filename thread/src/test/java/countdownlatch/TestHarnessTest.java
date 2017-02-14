package countdownlatch;

import static org.junit.Assert.*;

/**
 * Created by cq on 2017/1/23.
 */
public class TestHarnessTest {
    @org.junit.Test
    public void timeTasks() throws Exception {

        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };


        final int times = 20;

        TestHarness testHarness = new TestHarness();
        testHarness.timeTasks(times, runnable);

    }

}