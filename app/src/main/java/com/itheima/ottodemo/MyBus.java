package com.itheima.ottodemo;

import com.squareup.otto.Bus;

/**
 * Created by Leon on 2017/1/14.
 */

public class MyBus extends Bus{

    private static MyBus sMyBus;

    public static MyBus getInstance() {
        if (sMyBus == null) {
            synchronized (MyBus.class) {
                if (sMyBus == null) {
                    sMyBus = new MyBus();
                }
            }
        }
        return sMyBus;
    }
}
