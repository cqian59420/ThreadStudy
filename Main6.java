package Thread.ThreadStudy;

import java.util.Date;

/**
 * Main6 class of the Example. Create and start two initialization tasks
 * and wait for their finish
 */
public class Main6 {

    /**
     * Main6 method of the class. Create and star two initialization tasks
     * and wait for their finish
     *
     * @param args
     */
    public static void main(String[] args) {

        // Creates and starts a DataSourceLoader runnable object
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dsLoader, "DataSourceThread");
        thread1.start();

        // Creates and starts a NetworkConnectionsLoader runnable object
        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");
        thread2.start();

        // Wait for the finalization of the two threads
        try {
            thread1.join();
            thread2.join(2);// 等2ms，如果2ms后 Thread2还没执行完
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Waits a message
        System.out.printf("Main6: Configuration has been loaded: %s\n", new Date());
    }
}
