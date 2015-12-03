package com.massivedisaster.java.HelloRx.sample;

import com.massivedisaster.java.HelloRx.service.*;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by timartin on 1/12/2015.
 */
public class RxSample {

    public static void run() throws Exception {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        try {
            Scheduler scheduler = Schedulers.from(executorService);
            Observable.fromCallable(new ServiceA())
                    .subscribeOn(scheduler)
                    .map(o -> {
                        return new ServiceC(o).call();
                    }).subscribe();

            Observable.fromCallable(new ServiceB()).subscribeOn(scheduler)
                    .concatMap(o -> {
                        return Observable.just(new ServiceD(o).call());
                    })
                    .concatMap(o -> {
                        return Observable.just(new ServiceE(o).call());
                    }).subscribe();
        } finally {
            executorService.shutdown();
        }
    }
}
