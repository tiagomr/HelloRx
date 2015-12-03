package com.massivedisaster.java.HelloRx;

import com.massivedisaster.java.HelloRx.sample.CallbackSample;
import com.massivedisaster.java.HelloRx.sample.FutureSample;
import com.massivedisaster.java.HelloRx.sample.RxSample;
import com.massivedisaster.java.HelloRx.sample.RxSyncSample;

/**
 * Created by timartin on 1/12/2015.
 */
public class Main {
    public static void main(String [] args) throws Exception {
        //System.out.println("Future Sample:");
        //FutureSample.run();

        //System.out.println("Callback Sample:");
        //CallbackSample.run();


        System.out.println("Rx Sample:");
        RxSample.run();



        //System.out.println("RxSyncSample");
        //RxSyncSample.run();
    }
}
