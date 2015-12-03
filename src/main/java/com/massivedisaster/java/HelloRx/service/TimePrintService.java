package com.massivedisaster.java.HelloRx.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by timartin on 1/12/2015.
 */
public abstract class TimePrintService <T> implements Service<T>{
    private static final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public void doWork(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getTime() {
        Date date = new Date();
        return dateFormat.format(date);
    }
}
