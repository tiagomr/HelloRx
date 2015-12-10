package com.massivedisaster.java.HelloRx;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.schedulers.Schedulers;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by timartin on 10/12/2015.
 */
public class Hello {

    public static void main(String args[]) throws InterruptedException {

        Scheduler scheduler = Schedulers.from(new ScheduledThreadPoolExecutor(4));

        Observable<Integer> numberGenerator = Observable.<Integer>create(subscriber -> {
            Integer counter = 0;
            while (counter < 10) {
                try {
                    Thread.sleep(2000);
                    subscriber.onNext(counter++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            subscriber.onError(new RuntimeException("Sorry, I broke"));
        }).subscribeOn(scheduler);

        // The Subscription class is used to manage the connection between the Observer and the Observable
        Subscription numberSubscription = numberGenerator.subscribe(new MyObserver());
        Thread.sleep(4000);

        // It is functional so each operator creates a new Observer
        Observable<String> textGenerator = numberGenerator.map(integer -> {
            return "New number: " + integer;
        });

        Subscription textSubscription = textGenerator.subscribe(System.out::println);
        Thread.sleep(7000);
        textSubscription.unsubscribe();
    }
}
