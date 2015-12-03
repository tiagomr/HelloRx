package com.massivedisaster.java.HelloRx.service;

import java.util.concurrent.Callable;

/**
 * Created by timartin on 1/12/2015.
 */
public class ServiceC extends TimePrintService<String>{
    private final String dependency;

    public ServiceC(String dependency) {
        this.dependency = dependency;
    }

    @Override
    public String call() {
        doWork(60);
        System.out.println("ServiceC executed at " + getTime());
        return "responseB_" + dependency;
    }
}
