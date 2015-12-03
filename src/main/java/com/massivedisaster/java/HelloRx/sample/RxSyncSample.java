package com.massivedisaster.java.HelloRx.sample;

import com.massivedisaster.java.HelloRx.service.*;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.observables.BlockingObservable;
import rx.schedulers.Schedulers;
import rx.subjects.Subject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by timartin on 1/12/2015.
 */
public class RxSyncSample {

    public static void run() throws Exception {
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
        Scheduler scheduler = Schedulers.from(executorService);
        Observable<String> oC = Observable.fromCallable(new ServiceA()).subscribeOn(scheduler)
                .map(o -> {return new ServiceC(o).call();});
        Observable<Integer> oB = Observable.fromCallable(new ServiceB()).subscribeOn(scheduler);
        Observable<Integer> oD = Subject.<Integer>create(oB::subscribe)
                .map(o -> {return new ServiceD(o).call();});
        Observable<Integer> oE = Subject.<Integer>create(oB::subscribe)
                .map(o -> {return new ServiceE(o).call();});
        Observable<String> oFinal = Observable.zip(oC, oD, oE, (sCResult, sDResult, sEResult) -> {
            return "Service C:" + sCResult + " ServiceD:" + sDResult + " ServiceE:" + sEResult;
        });
        oFinal.subscribe(System.out::println);
        executorService.shutdown();
    }
}
