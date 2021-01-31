package com.mall.search.thread;
/*
 * File: TTest.java
 * Date: 2021-01-31 14:55
 * Author: msw
 * PS ...
 */


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TTest {

    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        System.out.println("Main start...");
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            double x = Math.random();
//            System.out.println("运行结果：" + x);
//        }, executorService);
//        System.out.println("Main end...");


//        System.out.println("Main start...");
//
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10/2;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executorService).whenComplete((result, exception) -> {
//            // 结束时执行
//            System.out.println("异步任务执行完毕...结果：" + result + "...异常为：" + exception);
//        }).exceptionally(throwable -> {
//            // 感知是否出现异常，若有异常可更改返回值
//            return -1;
//        });
//
//        System.out.println("Main end..., and result is: " + future.get());



//        System.out.println("Main start...");
//
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10/4;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executorService).thenApplyAsync( res -> {
//            System.out.println("任务2启动了..." + res);
//            return "Hello " + res;
//        }, executorService);
//
//        System.out.println("Main end..." + future.get());


        System.out.println("Main start...");

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task-1(Pid:<" + Thread.currentThread().getId() + ">) thread start...");
            int i = 10 / 4;
            System.out.println("Task-1(Pid:<" + Thread.currentThread().getId() + ">) thread end...");
            return i;
        }, executorService);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task-2(Pid:<" + Thread.currentThread().getId() + ">) thread start...");
            System.out.println("Task-2(Pid:<" + Thread.currentThread().getId() + ">) thread end...");
            return "Hello";
        }, executorService);

        future1.runAfterBothAsync(future2, () -> {
            // thread1.runAfterBothAsync(thread2): 两个任务都执行结束后
            System.out.println("Task-3(Pid:<" + Thread.currentThread().getId() + ">) thread start...");
        }, executorService);

        System.out.println("Main end...");
    }
}
