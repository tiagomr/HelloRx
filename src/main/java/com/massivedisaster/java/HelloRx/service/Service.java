package com.massivedisaster.java.HelloRx.service;
import java.util.concurrent.Callable;

/**
 * Generic marker interface that identifies a service that has a function call which return T
 * @param <T>
 */
public interface Service <T> extends Callable<T> {
}
