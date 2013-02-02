package Thread.ThreadStudy.ThreadException;

/**
 * Created by IntelliJ IDEA.
 * User: Terrance
 * Date: 13-2-2
 * Time: 下午11:32
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("不好了，发生异常\n");
        System.out.printf("发病的异常的ID为: %s\n",t.getId());
        System.out.printf("Exception: %s: %s\n",e.getClass().getName(),e.getMessage());
        System.out.printf("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n",t.getState());
    }
}
