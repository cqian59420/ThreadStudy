package Thread.ThreadStudy.LocalThread;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Terrance
 * Date: 13-2-3
 * Time: 上午1:35
 * To change this template use File | Settings | File Templates.
 */
public class Core {
    public static void main(String[] args) {
//        UnsafeTask task =new UnsafeTask();
        SafeTask task =new SafeTask();
        for (int i=0;i<10;i++){
            Thread thread =new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }
}
