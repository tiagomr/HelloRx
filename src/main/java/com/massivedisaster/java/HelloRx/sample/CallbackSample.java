package com.massivedisaster.java.HelloRx.sample;

import com.massivedisaster.java.HelloRx.service.*;

import java.util.concurrent.*;

/**
 * Shows that it is not easy to synchronize callbacks results
 */
public class CallbackSample {

    public static void run() throws Exception {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 5, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        executorService.execute(new CallbackAsyncServiceDecorator<String, ServiceA>(new ServiceA(), serviceResult ->
        {
            executorService.execute(new CallbackAsyncServiceDecorator<String, ServiceC>(new ServiceC(serviceResult), null));
        }));

        executorService.execute(new CallbackAsyncServiceDecorator<Integer, ServiceB>(new ServiceB(), serviceResult ->
        {
            executorService.execute(new CallbackAsyncServiceDecorator<Integer, ServiceD>(new ServiceD(serviceResult), null));
            executorService.execute(new CallbackAsyncServiceDecorator<Integer, ServiceE>(new ServiceE(serviceResult), null));
        }));

        //If I need to get all the values to print them how can I do it??

        Thread.sleep(5000);
        executorService.shutdown();
    }
}
