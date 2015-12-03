package com.massivedisaster.java.HelloRx.service;

import java.util.concurrent.Callable;

/**
 * Created by timartin on 1/12/2015.
 */
public class ServiceD extends TimePrintService<Integer> {
    private final Integer dependency;

    public ServiceD(Integer dependency) {
        this.dependency = dependency;
    }

    @Override
    public Integer call() {
        doWork(140);
        System.out.println("ServiceD executed at " + getTime());
        return 40 + dependency;
    }
}
