package com.massivedisaster.java.HelloRx.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by timartin on 2/12/2015.
 */
public class ParallelStreamSample {
    ExecutorService executorService = new ThreadPoolExecutor(4, 4, 5, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());








   /* Future<String> fA = executorService.submit(new ServiceA());
    Future<String> fC = executorService.submit(new ServiceC(fA.get()));
    Future<Integer> fB = executorService.submit(new ServiceB());
    Future<Integer> fD = executorService.submit(new ServiceD(fB.get()));
    Future<Integer> fE = executorService.submit(new ServiceE(fB.get()));
    System.out.println("Service C:" + fC.get() + " ServiceD:" + fD.get() + " ServiceE:" + fE.get());
    executorService.shutdown();*/
}
