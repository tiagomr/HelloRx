package com.massivedisaster.java.HelloRx.sample;

import com.massivedisaster.java.HelloRx.service.*;

import java.util.concurrent.*;

/**
 * Shows that nested futures can become blocking, performing their work in an asynchronous way
 */
public class FutureSample {
    public static void run() throws Exception {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 5, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        Future<String> fA = executorService.submit(new ServiceA());
        Future<String> fC = executorService.submit(new ServiceC(fA.get()));
        // The previous line will be blocked by fA.get() even though the code bellow has no dependency on it and could
        // be executed
        Future<Integer> fB = executorService.submit(new ServiceB());
        Future<Integer> fD = executorService.submit(new ServiceD(fB.get()));
        Future<Integer> fE = executorService.submit(new ServiceE(fB.get()));
        System.out.println("Service C:" + fC.get() + " ServiceD:" + fD.get() + " ServiceE:" + fE.get());
        executorService.shutdown();
    }
}
