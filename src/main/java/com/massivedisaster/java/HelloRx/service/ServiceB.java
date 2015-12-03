package com.massivedisaster.java.HelloRx.service;

import java.util.concurrent.Callable;

/**
 * Created by timartin on 1/12/2015.
 */
public class ServiceB extends TimePrintService<Integer>{
    @Override
    public Integer call() {
        doWork(40);
        System.out.println("ServiceB executed at " + getTime());
        return 100;
    }
}
