package Thread.ThreadStudy.ThreadException;

/**
 * Created by IntelliJ IDEA.
 * User: Terrance
 * Date: 13-2-3
 * Time: 上午12:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Task task =new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
