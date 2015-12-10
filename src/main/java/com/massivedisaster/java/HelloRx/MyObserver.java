package com.massivedisaster.java.HelloRx;

import rx.Observer;

/**
 * Created by timartin on 10/12/2015.
 */
public class MyObserver implements Observer<Integer> {
    @Override
    public void onCompleted() {
        System.out.println("Finished successfully :D");
    }

    @Override
    public void onError(Throwable e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println(integer);
    }
}
