package com.massivedisaster.java.HelloRx.callback;

/**
 * Created by timartin on 1/12/2015.
 */
public interface ServiceCallback <T> {
    void afterService(T serviceResult);
}
