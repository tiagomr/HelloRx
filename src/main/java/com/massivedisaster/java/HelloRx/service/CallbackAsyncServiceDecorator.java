package com.massivedisaster.java.HelloRx.service;

import com.massivedisaster.java.HelloRx.callback.ServiceCallback;

/**
 * Created by timartin on 1/12/2015.
 */
public class CallbackAsyncServiceDecorator <X, T extends TimePrintService<X>> implements Runnable{
    public final T service;
    public final ServiceCallback<X> callback;

    public CallbackAsyncServiceDecorator(T service, ServiceCallback<X> callback) {
        this.service = service;
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            X serviceResult = service.call();
            if(callback != null) {
                callback.afterService(serviceResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
