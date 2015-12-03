package com.massivedisaster.java.HelloRx.service;

import java.util.concurrent.Callable;

/**
 * Created by timartin on 1/12/2015.
 */
public class ServiceE extends TimePrintService<Integer> {
    private final Integer dependency;

    public ServiceE(Integer dependency) {
        this.dependency = dependency;
    }

    @Override
    public Integer call()  {
        doWork(55);
        System.out.println("ServiceE executed at " + getTime());
        return 5000 + dependency;
    }
}
