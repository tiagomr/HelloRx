package com.massivedisaster.java.HelloRx.service;

import java.util.concurrent.Callable;

/**
 * Created by timartin on 1/12/2015.
 */
public class ServiceA extends TimePrintService<String>{
    @Override
    public String call() {
        doWork(4000);
        System.out.println("ServiceA executed at " + getTime());
        return "ResponseA";
    }
}
