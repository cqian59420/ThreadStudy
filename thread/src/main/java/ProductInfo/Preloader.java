package ProductInfo;

import ProductInfo.ProductInfo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by cq on 2017/1/23.
 */
public class Preloader {

    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        public ProductInfo call() throws Exception {
            return null;
        }
    });


    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() {
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

}
