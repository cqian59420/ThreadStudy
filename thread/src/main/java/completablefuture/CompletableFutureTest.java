package completablefuture;

import lombok.extern.java.Log;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

// https://www.jianshu.com/p/4897ccdcb278  Java8新特性8--使用CompletableFuture构建异步应用
@Log
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {
//        new CompletableFutureTest().test1();
//        new CompletableFutureTest().test2();
//        new CompletableFutureTest().testDependence();
        new CompletableFutureTest().testDependenceNoSeq();
    }

    private void test1() throws Exception {
        CompletableFuture<String> completableFuture = new CompletableFuture();

        new Thread(() -> {
            log.info("tasking doing");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.complete("result");
        }).start();

        String result = completableFuture.get();
        log.info("计算结果:" + result);
    }


    public void test2() throws Exception {
        CompletableFuture<String> uCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("task1 doinng...");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result 1";
        });


        CompletableFuture<String> uCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            log.info("task2 doing...");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result2";
        });

        CompletableFuture<Object> anyResult = CompletableFuture.anyOf(uCompletableFuture, uCompletableFuture1);

        log.info("first finished result:" + anyResult.get());

        CompletableFuture<Void> allResult = CompletableFuture.allOf(uCompletableFuture, uCompletableFuture1);

        allResult.join();

        log.info("all complet task complete" + allResult);
    }


    public void testDependence() throws ExecutionException, InterruptedException {

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("task1 doing");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result1";
        });

        // task 1 完成了再做task2 ， 有个顺序
        CompletableFuture<String> stringCompletableFuture1 = stringCompletableFuture.thenCompose(s -> CompletableFuture.supplyAsync(() -> {
            log.info("task2 doing " + s);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result2 " + s;
        }));


        log.info("depence all called: " + stringCompletableFuture1.get());


    }

    // 各干各的，不必task2 等到task1 完成
    public void testDependenceNoSeq() throws ExecutionException, InterruptedException {

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            log.info("task1 doing");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result1";
        });
        //注册任务完成事件
        stringCompletableFuture.thenAccept(s -> log.info("stringCompletableFuture task is done"));

        //
        CompletableFuture<String> task2_doing = CompletableFuture.supplyAsync(() -> {
            log.info("task2 doing");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "2000";
        });

        task2_doing.thenAccept(s -> log.info("task2 is done"));

        CompletableFuture<String> stringCompletableFuture1 = stringCompletableFuture.thenCombine(task2_doing, (s, integer) -> s + integer);


        log.info("depence all called: " + stringCompletableFuture1.get());


    }
}
